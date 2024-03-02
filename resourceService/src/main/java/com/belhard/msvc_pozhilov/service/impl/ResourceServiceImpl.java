package com.belhard.msvc_pozhilov.service.impl;

import com.belhard.msvc_pozhilov.repository.ResourceRepository;
import com.belhard.msvc_pozhilov.service.MyMapper;
import com.belhard.msvc_pozhilov.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ResourceServiceImpl implements ResourceService {
    private final ResourceRepository resourceRepository;
    private final MyMapper myMapper;
}
