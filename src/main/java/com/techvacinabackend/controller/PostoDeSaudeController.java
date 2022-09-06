package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.model.PostoDeSaude;
import com.techvacinabackend.service.PostoDeSaudeService;

@RestController
@RequestMapping("/v1/api/posto")
public class PostoDeSaudeController {
	private final PostoDeSaudeService postoDeSaudeService;

	public PostoDeSaudeController(PostoDeSaudeService postoDeSaudeService) {
		super();
		this.postoDeSaudeService = postoDeSaudeService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("all")
	public ResponseEntity<List<PostoDeSaude>> listarTodos() {
		return new ResponseEntity<>(postoDeSaudeService.listarTodos(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<PostoDeSaude> retornarPostoDeSaude(@PathVariable long id) {
		return new ResponseEntity<>(postoDeSaudeService.acharPorId(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<PostoDeSaude> salvar(@RequestBody PostoDeSaude posto) {
		return new ResponseEntity<>(postoDeSaudeService.salvar(posto), HttpStatus.CREATED);
	}
}