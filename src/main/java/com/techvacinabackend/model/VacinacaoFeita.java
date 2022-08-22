package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VacinacaoFeita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Vacina vacina;

    @Column
    private int dose;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Doenca doenca;

    @Column
    private java.time.LocalDate data;

    
}
