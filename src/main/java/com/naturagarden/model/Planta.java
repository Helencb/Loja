package com.naturagarden.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "plantas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE plantas SET deletedAt = true WHERE id = ?")
public class Planta extends BaseEntity{

        private String nome;
        private Double preco;
        private String ambiente;
        private Boolean ativo = true;

    }
