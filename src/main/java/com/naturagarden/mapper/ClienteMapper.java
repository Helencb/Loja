package com.naturagarden.mapper;

import com.naturagarden.dto.ClienteCreateDTO;
import com.naturagarden.dto.ClienteResponseDTO;
import com.naturagarden.dto.ClienteUpdateDTO;
import com.naturagarden.model.Cliente;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ClienteMapper{
    Cliente toEntity(ClienteCreateDTO dto);

    ClienteResponseDTO toResponseDTO(Cliente cliente);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(ClienteUpdateDTO dto, @MappingTarget Cliente cliente);
}
