package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.model.Doenca;
import com.techvacinabackend.service.DoencaService;

@RestController
@RequestMapping("/v1/api/doenca")
public class DoencaController {
	private final DoencaService doencaService;

	public DoencaController(DoencaService doencaService) {
		super();
		this.doencaService = doencaService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Doenca>> listarTodos() {
		return new ResponseEntity<>(doencaService.listarTodos(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Doenca> salvar(@RequestBody Doenca doenca) {
		return new ResponseEntity<>(doencaService.salvar(doenca), HttpStatus.CREATED);
	}
}
