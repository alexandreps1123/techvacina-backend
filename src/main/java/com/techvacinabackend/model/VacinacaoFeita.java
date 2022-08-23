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
public class VacinacaoFeita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;

    @ManyToOne
    @Getter @Setter private Vacina vacina;

    @Column
    @Getter @Setter private int dose;

    @ManyToOne
    @Getter @Setter private Cliente cliente;

    @ManyToOne
    @Getter @Setter private Doenca doenca;

    @Column(nullable = false)
    @Getter @Setter private java.time.LocalDate data;

    public VacinacaoFeita() {
        super();
    }
    
}
