package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techvacinabackend.model.LembreteVacinacao;
import com.techvacinabackend.repository.LembreteVacinacaoRepository;

@Service
public class LembreteVacinacaoService {
	private final LembreteVacinacaoRepository lembreteVacinacaoRepository;

	public LembreteVacinacaoService(LembreteVacinacaoRepository lembreteVacinacaoRepository) {
		super();
		this.lembreteVacinacaoRepository = lembreteVacinacaoRepository;
	}
	
	public List<LembreteVacinacao> listarTodos() {
		return lembreteVacinacaoRepository.findAll();
	}

}
