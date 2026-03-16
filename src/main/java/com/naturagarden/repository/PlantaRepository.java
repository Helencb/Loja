package com.naturagarden.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.naturagarden.model.Planta;

import java.util.Optional;

public interface PlantaRepository extends JpaRepository<Planta, Long> {
        Page<Planta> findByDeletedAtIsNull(Pageable pageable);
        Optional<Planta> findByIdAndDeletedAtIsNull(Long id);
    }

