package com.naturagarden.mapper;

import com.naturagarden.dto.PlantaCreateDTO;
import com.naturagarden.dto.PlantaResponseDTO;
import com.naturagarden.dto.PlantaUpdateDTO;
import com.naturagarden.model.Planta;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlantaMapper {
    Planta toEntity(PlantaCreateDTO dto);

    PlantaResponseDTO toResponseDTO(Planta planta);

    void updateEntity(PlantaUpdateDTO dto, @MappingTarget Planta planta);
}
