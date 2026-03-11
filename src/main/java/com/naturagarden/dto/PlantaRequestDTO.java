package com.naturagarden.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlantaRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String ambiente;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal preco;

    private String imagemUrl;
}
