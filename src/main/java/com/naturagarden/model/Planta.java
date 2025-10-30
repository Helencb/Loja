package com.naturagarden.model;
import jakarta.persistence.*;
import lombok.Data;

    @Entity
    @Data
    public class Planta {

        // Getters e Setters
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;
        private Double preco;
        private String ambiente;

    }
