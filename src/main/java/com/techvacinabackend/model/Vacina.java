package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;

    @Column(unique = true, nullable = false)
    @Getter @Setter private String nome;

    @Column(nullable = false)
    @Getter @Setter private int doses;

    @Column
    @Getter @Setter private long intervaloEntreDoses; // em dias

    @Column(nullable = false)
    @Getter @Setter private long tempoDeEficacia; // em dias
    
    @ManyToOne(optional = false)
    @Getter @Setter private Doenca doenca;

    public Vacina() {
        super();
    }

}