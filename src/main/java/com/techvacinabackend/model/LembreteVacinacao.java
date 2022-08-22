package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LembreteVacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @Column(nullable = false)
    private Cliente cliente;

    @OneToOne
    @Column
    private VacinacaoPendente vacinacaoPendente;

    @Column
    private java.time.LocalDate data;
    
}
