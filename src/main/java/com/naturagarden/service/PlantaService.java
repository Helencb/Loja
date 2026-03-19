package com.naturagarden.service;

import com.naturagarden.dto.PlantaCreateDTO;
import com.naturagarden.dto.PlantaResponseDTO;
import com.naturagarden.dto.PlantaUpdateDTO;
import com.naturagarden.mapper.PlantaMapper;
import com.naturagarden.model.Planta;
import com.naturagarden.repository.PlantaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PlantaService extends BaseService<Planta> {

    private final PlantaRepository plantaRepository;
    private final PlantaMapper plantaMapper;

    public PlantaService(PlantaRepository plantaRepository, PlantaMapper plantaMapper){
        super(plantaRepository);





        this.plantaRepository = plantaRepository;
        this.plantaMapper = plantaMapper;
    }

    @Transactional
    public PlantaResponseDTO criar(PlantaCreateDTO dto) {
        Planta planta = plantaMapper.toEntity(dto);
        Planta salva = plantaRepository.save(planta);
        return plantaMapper.toResponseDTO(salva);
    }

    @Transactional
    public PlantaResponseDTO atualizar(UUID id, PlantaUpdateDTO dto) {
        Planta planta = buscarPorId(id);
        plantaMapper.updateEntity(dto, planta);
        Planta atualizada = plantaRepository.save(planta);
        return plantaMapper.toResponseDTO(atualizada);
    }
}
