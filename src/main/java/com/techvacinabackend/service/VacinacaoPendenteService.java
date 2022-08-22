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

}