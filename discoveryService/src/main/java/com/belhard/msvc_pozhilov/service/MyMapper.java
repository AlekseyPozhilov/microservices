package com.belhard.msvc_pozhilov.service;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MyMapper {
    DiscoveryEntity toEntity(DiscoveryDto discoveryDto);
    DiscoveryDto toDto(DiscoveryEntity discoveryEntity);
}
