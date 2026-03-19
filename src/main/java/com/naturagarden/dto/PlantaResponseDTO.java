package com.naturagarden.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PlantaResponseDTO (
        UUID id,
        String nome,
        BigDecimal preco,
        String ambiente
) {}
