package com.naturagarden.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PlantaUpdateDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotNull(message = "Preço é obrigatório")
        BigDecimal preco,
        @NotBlank(message = "Ambiente é obrigatório")
        String ambiente
) { }
