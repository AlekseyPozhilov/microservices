package com.belhard.msvc_pozhilov.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ResourceService {
    void uploadResource(MultipartFile file);

    byte[] getAudioData(Long id);

    void deleteResources(String ids);
}
