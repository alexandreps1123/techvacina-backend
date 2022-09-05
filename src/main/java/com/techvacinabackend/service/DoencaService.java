package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techvacinabackend.model.Doenca;
import com.techvacinabackend.repository.DoencaRepository;

@Service
public class DoencaService {
	private final DoencaRepository doencaRepository;

	public DoencaService(DoencaRepository doencaRepository) {
		super();
		this.doencaRepository = doencaRepository;
	}

	public Doenca acharPorId(long id) {
		return doencaRepository.findById(id).get();
	}
	
	public List<Doenca> listarTodos() {
		return doencaRepository.findAll();
	}

	public Doenca salvar(Doenca doenca) {
		return doencaRepository.save(doenca);
	}

	public Doenca acharPorNome(String doencaNome) {
		return doencaRepository.findByNome(doencaNome);
	}

}
