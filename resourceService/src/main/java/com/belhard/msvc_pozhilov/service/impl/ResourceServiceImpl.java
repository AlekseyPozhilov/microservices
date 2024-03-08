package com.belhard.msvc_pozhilov.service.impl;

import com.belhard.msvc_pozhilov.data.entity.ResourceEntity;
import com.belhard.msvc_pozhilov.data.repository.ResourceRepository;
import com.belhard.msvc_pozhilov.dto.ResourceDto;
import com.belhard.msvc_pozhilov.service.MyMapper;
import com.belhard.msvc_pozhilov.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ResourceServiceImpl implements ResourceService {
    private final ResourceRepository resourceRepository;
    private final MyMapper myMapper;

    @Override
    public void uploadResource(MultipartFile file) {
        try {
            ResourceDto resourceDto = new ResourceDto();
            resourceDto.setMetadata(Arrays.toString(file.getBytes()));
            resourceDto.setMetadata(file.getOriginalFilename());
            resourceDto.setTimestamp(new Date());

            ResourceEntity resourceEntity = myMapper.toEntity(resourceDto);
            resourceRepository.save(resourceEntity);
            log.info("Uploaded resource with ID: " + resourceEntity.getId());
        } catch (IOException e) {
            log.error("Error uploading resource: " + e.getMessage());
        }
    }

    @Override
    public byte[] getAudioData(Long id) {
        return resourceRepository.findById(id)
                .map(ResourceEntity::getAudioData)
                .orElse(new byte[0]);
    }

    @Override
    public void deleteResources(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            try {
                Long resourceId = Long.parseLong(id);
                resourceRepository.deleteById(resourceId);
                log.info("Deleted resource with ID: " + resourceId);
            } catch (NumberFormatException e) {
                log.error("Invalid resource ID format: " + id);
            }
        }
    }
}
