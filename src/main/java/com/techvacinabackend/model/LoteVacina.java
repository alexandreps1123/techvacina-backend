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
public class LoteVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;

    @ManyToOne(optional = false)
    @Getter @Setter private Vacina vacina;

    @Column (nullable = false)
    @Getter @Setter private long quantidade;

    @Column (nullable = false)
    @Getter @Setter private java.time.LocalDate recebimento;

    @Column (nullable = false)
    @Getter @Setter private java.time.LocalDate validade;

    @ManyToOne (optional = false)
    @Getter @Setter private PostoDeSaude posto;

    public LoteVacina() {
        super();
    }
}
