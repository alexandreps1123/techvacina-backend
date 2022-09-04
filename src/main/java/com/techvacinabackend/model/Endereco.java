package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;

    @Column(nullable = false)
    @Getter @Setter private String cidade;

    @Column(nullable = false)
    @Getter @Setter private String estado;

    @Column(nullable = false)
    @Getter @Setter private String pais;

    @Column(nullable = false)
    @Getter @Setter private String bairro;

    @Column(nullable = false)
    @Getter @Setter private String linha;

    @Column(nullable = false)
    @Getter @Setter private String cep;

    public Endereco() {
        super();
    }
}
