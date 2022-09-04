package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techvacinabackend.model.Endereco;
import com.techvacinabackend.repository.EnderecoRepository;

@Service
public class EnderecoService {
	private final EnderecoRepository enderecoRepository;

	public EnderecoService(EnderecoRepository enderecoRepository) {
		super();
		this.enderecoRepository = enderecoRepository;
	}

	public Endereco acharPorId(long id) {
		return enderecoRepository.findById(id).get();
	}
	
	public List<Endereco> listarTodos() {
		return enderecoRepository.findAll();
	}

	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

}