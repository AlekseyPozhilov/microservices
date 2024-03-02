package com.belhard.msvc_pozhilov.repository;

import com.belhard.msvc_pozhilov.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
