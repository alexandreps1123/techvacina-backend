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

import com.techvacinabackend.model.Endereco;
import com.techvacinabackend.service.EnderecoService;

@RestController
@RequestMapping("/v1/api/endereco")
public class EnderecoController {
	private final EnderecoService enderecoService;

	public EnderecoController(EnderecoService enderecoService) {
		super();
		this.enderecoService = enderecoService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("all")
	public ResponseEntity<List<Endereco>> listarTodos() {
		return new ResponseEntity<>(enderecoService.listarTodos(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> retornarEndereco(@PathVariable long id) {
		return new ResponseEntity<>(enderecoService.acharPorId(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco) {
		return new ResponseEntity<>(enderecoService.salvar(endereco), HttpStatus.CREATED);
	}
}
