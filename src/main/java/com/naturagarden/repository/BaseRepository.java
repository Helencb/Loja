package com.naturagarden.repository;

import com.naturagarden.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {
    Page<T> findByDeletedAtIsNull(Pageable pageable);
    Optional<T> findByIdAndDeletedAtIsNull(UUID id);
}
