package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techvacinabackend.model.VacinacaoPendente;
import com.techvacinabackend.repository.VacinacaoPendenteRepository;

@Service
public class VacinacaoPendenteService {
	private final VacinacaoPendenteRepository vacinacaoPendenteRepository;

	public VacinacaoPendenteService(VacinacaoPendenteRepository vacinacaoPendenteRepository) {
		super();
		this.vacinacaoPendenteRepository = vacinacaoPendenteRepository;
	}
	
	public List<VacinacaoPendente> listarTodos() {
		return vacinacaoPendenteRepository.findAll();
	}

	public VacinacaoPendente salvar(VacinacaoPendente vacinacao) {
		return vacinacaoPendenteRepository.save(vacinacao);
	}

	public VacinacaoPendente acharPorClienteIdEDoencaEVacina(Long clienteId, String doencaNome, String vacinaNome) {
		return vacinacaoPendenteRepository
		.findByCliente_IdAndDoenca_NomeAndVacina_Nome(
			clienteId, doencaNome, vacinaNome
		);
	}

	public void apagar(VacinacaoPendente vacinacaoPendente) {
		vacinacaoPendenteRepository.delete(vacinacaoPendente);
	}
}