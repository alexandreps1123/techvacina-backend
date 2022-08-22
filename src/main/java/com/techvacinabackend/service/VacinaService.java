package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techvacinabackend.model.Vacina;
import com.techvacinabackend.repository.VacinaRepository;

@Service
public class VacinaService {
	private final VacinaRepository vacinaRepository;

	public VacinaService(VacinaRepository vacinaRepository) {
		super();
		this.vacinaRepository = vacinaRepository;
	}
	
	public List<Vacina> listarTodos() {
		return vacinaRepository.findAll();
	}

}