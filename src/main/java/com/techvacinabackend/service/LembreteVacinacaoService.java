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

	public LembreteVacinacao acharPorId(long id) {
		return lembreteVacinacaoRepository.findById(id).get();
	}

	public List<LembreteVacinacao> acharPorClienteId(long clienteId) {
		return lembreteVacinacaoRepository.findAllByCliente_Id(clienteId);
	}

	public LembreteVacinacao acharPorClienteENomeDoenca(long clienteId, long doencaId) {
		return lembreteVacinacaoRepository.findByCliente_IdAndDoenca_Id(clienteId, doencaId);
	}

	public LembreteVacinacao salvar(LembreteVacinacao lembrete) {
		return lembreteVacinacaoRepository.save(lembrete);
	}

	public void deletar(LembreteVacinacao lembrete) {
		lembreteVacinacaoRepository.deleteById(lembrete.getId());
	}

}
