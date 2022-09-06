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

	public Vacina acharPorId(long id) {
		return vacinaRepository.findById(id).get();
	}

	public Vacina salvar(Vacina vacina) {
		return vacinaRepository.save(vacina);
	}

	public Vacina acharPorNome(String vacinaNome) {
		return vacinaRepository.findByNome(vacinaNome);
	}

}