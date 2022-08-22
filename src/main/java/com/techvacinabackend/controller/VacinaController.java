package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.model.Vacina;
import com.techvacinabackend.service.VacinaService;

@RestController
@RequestMapping("/v1/api/vacina")
public class VacinaController {
	private final VacinaService vacinaService;

	public VacinaController(VacinaService vacinaService) {
		super();
		this.vacinaService = vacinaService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Vacina>> listarTodos() {
		return new ResponseEntity<>(vacinaService.listarTodos(), HttpStatus.OK);
	}
}
