package com.naturagarden.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class PlantaResponseDTO {
    private Long id;
    private String nome;
    private String ambiente;
    private BigDecimal preco;
    private String imagemUrl;
}
