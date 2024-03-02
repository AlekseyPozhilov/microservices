package com.belhard.msvc_pozhilov.service.impl;

import com.belhard.msvc_pozhilov.repository.SongRepository;
import com.belhard.msvc_pozhilov.service.MyMapper;
import com.belhard.msvc_pozhilov.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final MyMapper myMapper;
}
