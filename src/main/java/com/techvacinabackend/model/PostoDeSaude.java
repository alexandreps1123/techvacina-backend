package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PostoDeSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;

    @Column(nullable = false)
    @Getter @Setter private String nome;

    @OneToOne
    @Getter @Setter private Endereco endereco;

    public PostoDeSaude() {
        super();
    }
    
}
