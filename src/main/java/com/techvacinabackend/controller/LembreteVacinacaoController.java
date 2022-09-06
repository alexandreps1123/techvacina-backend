package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.dto.LembreteDTO;
import com.techvacinabackend.model.Cliente;
import com.techvacinabackend.model.Doenca;
import com.techvacinabackend.model.LembreteVacinacao;
import com.techvacinabackend.model.VacinacaoMaisRecente;
import com.techvacinabackend.service.ClienteService;
import com.techvacinabackend.service.DoencaService;
import com.techvacinabackend.service.LembreteVacinacaoService;
import com.techvacinabackend.service.VacinacaoMaisRecenteService;

@RestController
@RequestMapping("/v1/api/lembretevacinacao")
public class LembreteVacinacaoController {
	private final LembreteVacinacaoService lembreteVacinacaoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private DoencaService doencaService;

	@Autowired
	private VacinacaoMaisRecenteService vacinacaoMaisRecenteService;

	public LembreteVacinacaoController(LembreteVacinacaoService lembreteVacinacaoService) {
		super();
		this.lembreteVacinacaoService = lembreteVacinacaoService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("all")
	public ResponseEntity<List<LembreteVacinacao>> listarTodos() {
		return new ResponseEntity<>(lembreteVacinacaoService.listarTodos(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<LembreteVacinacao> retornarLembrete(@PathVariable long id) {
		return new ResponseEntity<>(lembreteVacinacaoService.acharPorId(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/cliente/doenca")
	public ResponseEntity<LembreteVacinacao> retornarLembrete(@RequestBody LembreteDTO lembreteDTO) {
		Long doencaId = doencaService.acharPorNome(lembreteDTO.doencaNome).getId();
		return new ResponseEntity<>(lembreteVacinacaoService
			.acharPorClienteENomeDoenca(lembreteDTO.clienteId, doencaId), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<LembreteVacinacao> salvar(@RequestBody LembreteDTO lembreteDTO) {
		LembreteVacinacao lembrete = new LembreteVacinacao();
		Cliente cliente = clienteService.acharPorId(lembreteDTO.clienteId);
		Doenca doenca = doencaService.acharPorNome(lembreteDTO.doencaNome);
		lembrete.setCliente(cliente);
		lembrete.setDoenca(doenca);

		// Se houver registro de vacinação mais recente, ela é usada para definir a data de vacinação sugerida.
		VacinacaoMaisRecente vacinacaoRecente = vacinacaoMaisRecenteService
			.acharPorClienteENomeDoenca(lembreteDTO.clienteId, lembreteDTO.doencaNome);
		java.time.LocalDate data;
		if (vacinacaoRecente != null) {
			data = vacinacaoRecente.getDataPrevistaProxima();
		} else {
			data = java.time.LocalDate.now();
		}
		lembrete.setData(data);
		return new ResponseEntity<>(lembreteVacinacaoService.salvar(lembrete), HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping()
	public ResponseEntity<Void> deletar(@RequestBody LembreteVacinacao lembrete) {
		lembreteVacinacaoService.deletar(lembrete);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}