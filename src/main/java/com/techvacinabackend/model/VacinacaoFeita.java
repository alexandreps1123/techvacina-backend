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

    @ManyToOne(optional = false)
    @Getter @Setter private Vacina vacina;

    @ManyToOne (optional = false)
    @Getter @Setter private LoteVacina lote;

    @Column
    @Getter @Setter private int dose;

    @ManyToOne (optional = false)
    @Getter @Setter private Cliente cliente;

    @ManyToOne (optional = false)
    @Getter @Setter private Doenca doenca;

    @Column(nullable = false)
    @Getter @Setter private java.time.LocalDate data;

    @ManyToOne(optional = false)
    @Getter @Setter private PostoDeSaude posto;

    public VacinacaoFeita() {
        super();
    }
    
}
