package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VacinacaoPendente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Doenca doenca;

    @ManyToOne
    private Vacina vacina;

    @Column
    private int dose;

    @Column
    private int dosesRestantes;

    @Column
    private java.time.LocalDate data;

    
}