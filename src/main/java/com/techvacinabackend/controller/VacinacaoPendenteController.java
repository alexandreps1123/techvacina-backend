package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.model.VacinacaoPendente;
import com.techvacinabackend.service.VacinacaoPendenteService;

@RestController
@RequestMapping("/v1/api/vacinacaopendente")
public class VacinacaoPendenteController {
	private final VacinacaoPendenteService vacinacaoPendenteService;

	public VacinacaoPendenteController(VacinacaoPendenteService vacinacaoPendenteService) {
		super();
		this.vacinacaoPendenteService = vacinacaoPendenteService;
	}
	
	@GetMapping()
	public ResponseEntity<List<VacinacaoPendente>> listarTodos() {
		return new ResponseEntity<>(vacinacaoPendenteService.listarTodos(), HttpStatus.OK);
	}
}
