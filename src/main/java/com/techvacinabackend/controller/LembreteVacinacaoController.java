package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.model.LembreteVacinacao;
import com.techvacinabackend.service.LembreteVacinacaoService;

@RestController
@RequestMapping("/v1/api/lembretevacinacao")
public class LembreteVacinacaoController {
	private final LembreteVacinacaoService lembreteVacinacaoService;

	public LembreteVacinacaoController(LembreteVacinacaoService lembreteVacinacaoService) {
		super();
		this.lembreteVacinacaoService = lembreteVacinacaoService;
	}
	
	@GetMapping()
	public ResponseEntity<List<LembreteVacinacao>> listarTodos() {
		return new ResponseEntity<>(lembreteVacinacaoService.listarTodos(), HttpStatus.OK);
	}
}
