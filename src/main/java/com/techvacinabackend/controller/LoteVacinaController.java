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

import com.techvacinabackend.model.LoteVacina;
import com.techvacinabackend.service.LoteVacinaService;

@RestController
@RequestMapping("/v1/api/lotevacina")
public class LoteVacinaController {
	private final LoteVacinaService loteVacinaService;

	public LoteVacinaController(LoteVacinaService loteVacinaService) {
		super();
		this.loteVacinaService = loteVacinaService;
	}
	
	@GetMapping("all")
	public ResponseEntity<List<LoteVacina>> listarTodos() {
		return new ResponseEntity<>(loteVacinaService.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LoteVacina> retornarLoteVacina(@PathVariable long id) {
		return new ResponseEntity<>(loteVacinaService.acharPorId(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<LoteVacina> salvar(@RequestBody LoteVacina loteVacina) {
		return new ResponseEntity<>(loteVacinaService.salvar(loteVacina), HttpStatus.CREATED);
	}
}