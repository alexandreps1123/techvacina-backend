package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class VacinacaoMaisRecente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;

    @ManyToOne(optional = false)
    @Getter @Setter Cliente cliente;

    @ManyToOne(optional = false)
    @Getter @Setter Doenca doenca;
    
    @OneToOne(optional = false)
    @Getter @Setter VacinacaoFeita vacinacao;

    @Column
    @Getter @Setter java.time.LocalDate dataPrevistaProxima;

    public VacinacaoMaisRecente() {
        super();
    }
    
}
