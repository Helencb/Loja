package com.naturagarden.dto;

import java.math.BigDecimal;

public record PlantaResponseDTO (
        Long id,
        String nome,
        BigDecimal preco,
        String ambiente
) {}
