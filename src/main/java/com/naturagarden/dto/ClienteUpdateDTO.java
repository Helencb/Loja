package com.naturagarden.dto;

import jakarta.validation.constraints.Email;

public record ClienteUpdateDTO(
        String nome,

        @Email(message = "Email inválido")
        String email,

        String telefone
) {
}
