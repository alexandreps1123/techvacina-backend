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
    private Cliente cliente;

    // @OneToOne
    // private VacinacaoPendente vacinacaoPendente;

    @Column
    private java.time.LocalDate data;

    public LembreteVacinacao() {
        super();
    }
    
}
