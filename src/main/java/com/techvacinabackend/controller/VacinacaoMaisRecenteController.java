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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("all")
	public ResponseEntity<List<VacinacaoMaisRecente>> listarTodos() {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.listarTodos(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<VacinacaoMaisRecente> retornarVacinacaoMaisRecente(@PathVariable long id) {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.acharPorId(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("cliente/{clienteId}")
	public ResponseEntity<List<VacinacaoMaisRecente>> retornarTodasPorCliente(@PathVariable long clienteId) {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.acharTodasPorCliente(clienteId), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("cliente/{clienteId}/doencaNome='{doencaNome}'")
	public ResponseEntity<VacinacaoMaisRecente> retornarMaisRecentePorClienteEDoencaNome(@PathVariable long clienteId, @PathVariable String doencaNome) {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.acharPorClienteENomeDoenca(clienteId, doencaNome), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("cliente/{clienteId}/doencaId={doencaId}")
	public ResponseEntity<VacinacaoMaisRecente> retornarMaisRecentePorClienteEDoencaId(@PathVariable long clienteId, @PathVariable Long doencaId) {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.acharPorClienteEDoencaId(clienteId, doencaId), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<VacinacaoMaisRecente> salvar(@RequestBody VacinacaoMaisRecente vacinacaoMaisRecente) {
		return new ResponseEntity<>(vacinacaoMaisRecenteService.salvar(vacinacaoMaisRecente), HttpStatus.CREATED);
	}
}