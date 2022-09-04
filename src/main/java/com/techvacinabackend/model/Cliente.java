package com.techvacinabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente {
	@Id
	private Long id;
	private String nome;

	@Column(unique = true, nullable = false)
	@Getter @Setter private String cpf;

	@ManyToOne(optional = false)
	@Getter @Setter private Endereco endereco;

	@Column
	@Getter @Setter private String telefone;

	
	public Cliente() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
