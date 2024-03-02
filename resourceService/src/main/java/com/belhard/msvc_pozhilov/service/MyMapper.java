package com.belhard.msvc_pozhilov.service;

import com.belhard.msvc_pozhilov.dto.ResourceDto;
import com.belhard.msvc_pozhilov.entity.ResourceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MyMapper {
    ResourceEntity toEntity(ResourceDto resourceDto);
    ResourceDto toDto(ResourceEntity resourceEntity);
}
