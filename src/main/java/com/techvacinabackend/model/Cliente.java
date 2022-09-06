package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;

	private String nome;

	@Column(unique = true, nullable = false)
	@Getter @Setter private String cpf;

	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@Getter @Setter private Endereco endereco;

	@Column
	@Getter @Setter private String telefone;

	
	public Cliente() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
