package com.belhard.msvc_pozhilov.data.repository;

import com.belhard.msvc_pozhilov.data.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {
}
