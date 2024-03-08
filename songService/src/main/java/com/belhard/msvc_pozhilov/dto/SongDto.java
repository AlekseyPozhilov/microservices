package com.belhard.msvc_pozhilov.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SongDto {
    private Long id;
    private String title;
    private String artist;
    private String album;
    private Integer length;
    private Integer resourceId;
    private Integer year;
    private Date createdTimestamp;
}
