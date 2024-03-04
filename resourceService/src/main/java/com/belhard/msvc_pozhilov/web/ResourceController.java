package com.belhard.msvc_pozhilov.web;

import com.belhard.msvc_pozhilov.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ResourceController {
    private final ResourceService resourceService;


}
