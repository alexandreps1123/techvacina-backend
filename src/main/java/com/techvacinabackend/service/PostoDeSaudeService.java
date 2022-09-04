package com.techvacinabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techvacinabackend.model.PostoDeSaude;
import com.techvacinabackend.repository.PostoDeSaudeRepository;

@Service
public class PostoDeSaudeService {
	private final PostoDeSaudeRepository postoDeSaudeRepository;

	public PostoDeSaudeService(PostoDeSaudeRepository postoDeSaudeRepository) {
		super();
		this.postoDeSaudeRepository = postoDeSaudeRepository;
	}
	
	public List<PostoDeSaude> listarTodos() {
		return postoDeSaudeRepository.findAll();
	}
	
	public PostoDeSaude salvar(PostoDeSaude posto) {
		return postoDeSaudeRepository.save(posto);
	}

	public PostoDeSaude acharPorId(Long postoId) {
		return postoDeSaudeRepository.findById(postoId).get();
	}
}