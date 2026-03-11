package com.naturagarden.mapper;

import com.naturagarden.dto.PlantaRequestDTO;
import com.naturagarden.dto.PlantaResponseDTO;
import com.naturagarden.model.Planta;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PlantaMapper {
    Planta toEntity(PlantaRequestDTO dto);

    PlantaResponseDTO toResponseDTO(Planta planta);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePlantaFromDto(PlantaRequestDTO dto, @MappingTarget Planta planta);
}
