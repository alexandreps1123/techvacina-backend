package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.techvacinabackend.model.VacinacaoMaisRecente;
import com.techvacinabackend.service.VacinacaoMaisRecenteService;

@RestController
@RequestMapping("/v1/api/vacinacaomaisrecente")
public class VacinacaoMaisRecenteController {
	private final VacinacaoMaisRecenteService vacinacaoMaisRecenteService;

	public VacinacaoMaisRecenteController(VacinacaoMaisRecenteService vacinacaoMaisRecenteService) {
		super();
		this.vacinacaoMaisRecenteService = vacinacaoMaisRecenteService;
	}
	
	@GetMapping("all")
	public ResponseEntity<List<VacinacaoMaisRecente>> listarTodos() {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VacinacaoMaisRecente> retornarVacinacaoMaisRecente(@PathVariable long id) {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.acharPorId(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<VacinacaoMaisRecente> salvar(@RequestBody VacinacaoMaisRecente vacinacaoMaisRecente) {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.salvar(vacinacaoMaisRecente), HttpStatus.CREATED);
	}
}