package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.model.VacinacaoFeita;
import com.techvacinabackend.service.VacinacaoFeitaService;

@RestController
@RequestMapping("/v1/api/vacinacaofeita")
public class VacinacaoFeitaController {
	private final VacinacaoFeitaService vacinacaoFeitaService;

	public VacinacaoFeitaController(VacinacaoFeitaService vacinacaoFeitaService) {
		super();
		this.vacinacaoFeitaService = vacinacaoFeitaService;
	}
	
	@GetMapping()
	public ResponseEntity<List<VacinacaoFeita>> listarTodos() {
		return new ResponseEntity<>(vacinacaoFeitaService.listarTodos(), HttpStatus.OK);
	}
}
