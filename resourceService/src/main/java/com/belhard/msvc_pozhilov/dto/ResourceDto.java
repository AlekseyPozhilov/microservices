package com.belhard.msvc_pozhilov.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ResourceDto {
    private Long id;
    private String metadata;
    private Date timestamp;
    private String audioLink;
}
