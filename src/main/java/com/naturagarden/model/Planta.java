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
public class Planta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;
        private Double preco;
        private String ambiente;
        private String imagemUrl;
        private Boolean ativo = true;

    }
