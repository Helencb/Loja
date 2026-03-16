package com.naturagarden.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plantas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planta extends BaseEntity{

        private String nome;
        private Double preco;
        private String ambiente;
        private Boolean ativo = true;

    }
