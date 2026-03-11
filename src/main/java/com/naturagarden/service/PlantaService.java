package com.naturagarden.service;

import com.naturagarden.dto.PlantaRequestDTO;
import com.naturagarden.dto.PlantaResponseDTO;
import com.naturagarden.exception.PlantaNaoEncontradaException;
import com.naturagarden.mapper.PlantaMapper;
import com.naturagarden.model.Planta;
import com.naturagarden.repository.PlantaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlantaService {
    private final PlantaRepository plantaRepository;
    private final PlantaMapper plantaMapper;

    @Transactional
    public PlantaResponseDTO criar(PlantaRequestDTO dto) {
        Planta planta = plantaMapper.toEntity(dto);
        planta.setAtivo(true);
        Planta salva = plantaRepository.save(planta);
        return plantaMapper.toResponseDTO(salva);
    }

    @Transactional(readOnly = true)
    public PlantaResponseDTO buscarPorId(Long id){
        Planta planta = plantaRepository.findById(id)
                .filter(Planta::getAtivo)
                .orElseThrow(() -> new PlantaNaoEncontradaException(id));
        return  plantaMapper.toResponseDTO(planta);
    }

    @Transactional(readOnly = true)
    public Page<PlantaResponseDTO> listar(Pageable pageable){
        return plantaRepository.findByAtivoTrue(pageable)
                .map(plantaMapper::toResponseDTO);
    }

    @Transactional
    public PlantaResponseDTO atualizar(Long id, PlantaRequestDTO dto) {
        Planta planta = plantaRepository.findById(id)
                .filter(Planta::getAtivo)
                .orElseThrow(() -> new PlantaNaoEncontradaException(id));

        plantaMapper.updatePlantaFromDto(dto, planta);

        Planta atualizada = plantaRepository.save(planta);
        return plantaMapper.toResponseDTO(atualizada);
    }

    @Transactional
    public void deletar(Long id){
        Planta planta = plantaRepository.findById(id)
                .filter(Planta::getAtivo)
                .orElseThrow(() -> new PlantaNaoEncontradaException(id));
        planta.setAtivo(false);
        plantaRepository.save(planta);
    }
}
