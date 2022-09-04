package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techvacinabackend.model.LoteVacina;
import com.techvacinabackend.repository.LoteVacinaRepository;

@Service
public class LoteVacinaService {
	private final LoteVacinaRepository loteVacinaRepository;

	public LoteVacinaService(LoteVacinaRepository loteVacinaRepository) {
		super();
		this.loteVacinaRepository = loteVacinaRepository;
	}
	
	public List<LoteVacina> listarTodos() {
		return loteVacinaRepository.findAll();
	}

	public LoteVacina acharPorId(long id) {
		return loteVacinaRepository.findById(id).get();
	}

	public LoteVacina salvar(LoteVacina lote) {
		return loteVacinaRepository.save(lote);
	}

}