package com.belhard.msvc_pozhilov.data.repository;

import com.belhard.msvc_pozhilov.data.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
