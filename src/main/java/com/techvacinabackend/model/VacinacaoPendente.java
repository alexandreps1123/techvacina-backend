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
public class VacinacaoPendente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;

    @ManyToOne(optional = false)
    @Getter @Setter private Cliente cliente;

    @ManyToOne(optional = false)
    @Getter @Setter private Doenca doenca;

    @ManyToOne(optional = false)
    @Getter @Setter private Vacina vacina;

    @Column(nullable = false)
    @Getter @Setter private int dose;

    @Column(nullable = false)
    @Getter @Setter private int dosesRestantes;

    @Column
    @Getter @Setter private java.time.LocalDate data;

    public VacinacaoPendente() {
        super();
    }

}