package com.naturagarden.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.naturagarden.model.Planta;

    public interface PlantaRepository extends JpaRepository<Planta, Long> {
    }

