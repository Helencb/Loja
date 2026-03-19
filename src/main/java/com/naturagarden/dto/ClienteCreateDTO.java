package com.naturagarden.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteCreateDTO (
        @NotBlank(message = "Noe é obrigatório")
        String nome,

        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "Senha é obrigatório")
        @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres.")
        String senha,

        String telefone,

        @NotBlank(message = "CPF é obrigatório")
        String cpf
){
}
