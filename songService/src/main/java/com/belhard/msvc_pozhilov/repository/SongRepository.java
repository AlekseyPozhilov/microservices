package com.belhard.msvc_pozhilov.repository;

import com.belhard.msvc_pozhilov.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {
}
