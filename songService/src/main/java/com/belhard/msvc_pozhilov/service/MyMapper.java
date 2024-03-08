package com.belhard.msvc_pozhilov.service;

import com.belhard.msvc_pozhilov.dto.SongDto;
import com.belhard.msvc_pozhilov.data.entity.SongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MyMapper {
    SongEntity toEntity(SongDto songDto);
    SongDto toDto(SongEntity songEntity);
}
