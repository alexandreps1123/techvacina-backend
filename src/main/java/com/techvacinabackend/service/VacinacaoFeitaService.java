package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techvacinabackend.model.VacinacaoFeita;
import com.techvacinabackend.repository.VacinacaoFeitaRepository;

@Service
public class VacinacaoFeitaService {
	private final VacinacaoFeitaRepository vacinacaoFeitaRepository;

	public VacinacaoFeitaService(VacinacaoFeitaRepository vacinacaoFeitaRepository) {
		super();
		this.vacinacaoFeitaRepository = vacinacaoFeitaRepository;
	}
	
	public List<VacinacaoFeita> listarTodos() {
		return vacinacaoFeitaRepository.findAll();
	}

	public VacinacaoFeita acharPorId(long id) {
		return vacinacaoFeitaRepository.findById(id).get();
	}

	public List<VacinacaoFeita> acharPorCliente(long id) {
		return vacinacaoFeitaRepository.findByCliente_Id(id);
	}

	public VacinacaoFeita salvar(VacinacaoFeita vacinacao) {
		return vacinacaoFeitaRepository.save(vacinacao);
	}

}
