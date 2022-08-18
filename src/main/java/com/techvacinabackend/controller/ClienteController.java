package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.model.Cliente;
import com.techvacinabackend.service.ClienteService;

@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteController {
	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> listarTodos() {
		return new ResponseEntity<>(clienteService.listarTodos(), HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.salvar(cliente), HttpStatus.CREATED);
	}
}
