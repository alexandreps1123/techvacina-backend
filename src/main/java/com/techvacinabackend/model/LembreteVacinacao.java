package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cliente_id", "doenca_id" }) })
public class LembreteVacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id;

    @ManyToOne
    @Getter @Setter private Cliente cliente;

    @ManyToOne
    @Getter @Setter private Doenca doenca;

    @Column
    @Getter @Setter private java.time.LocalDate data;

    public LembreteVacinacao() {
        super();
    }
    
}
