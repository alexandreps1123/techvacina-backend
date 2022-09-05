package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techvacinabackend.model.VacinacaoMaisRecente;
import com.techvacinabackend.repository.VacinacaoMaisRecenteRepository;

@Service
public class VacinacaoMaisRecenteService {
	private final VacinacaoMaisRecenteRepository vacinacaoMaisRecenteRepository;

	public VacinacaoMaisRecenteService(VacinacaoMaisRecenteRepository vacinacaoMaisRecenteRepository) {
		super();
		this.vacinacaoMaisRecenteRepository = vacinacaoMaisRecenteRepository;
	}
	
	public List<VacinacaoMaisRecente> listarTodos() {
		return vacinacaoMaisRecenteRepository.findAll();
	}

    public List<VacinacaoMaisRecente> acharTodasPorCliente(long id) {
		return vacinacaoMaisRecenteRepository.findAllByCliente_Id(id);
	}

	public VacinacaoMaisRecente acharPorId(long id) {
		return vacinacaoMaisRecenteRepository.findById(id).get();
	}

	public VacinacaoMaisRecente acharPorClienteENomeDoenca(long id, String doencaNome) {
		return vacinacaoMaisRecenteRepository.findByCliente_IdAndDoenca_Nome(id, doencaNome);
	}

	public VacinacaoMaisRecente salvar(VacinacaoMaisRecente vacinacao) {
		return vacinacaoMaisRecenteRepository.save(vacinacao);
	}

}
