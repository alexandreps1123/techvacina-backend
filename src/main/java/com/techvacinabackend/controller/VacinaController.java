package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.techvacinabackend.model.Vacina;
import com.techvacinabackend.model.Doenca;
import com.techvacinabackend.service.VacinaService;
import com.techvacinabackend.service.DoencaService;
import com.techvacinabackend.dto.VacinaDTO;

@RestController
@RequestMapping("/v1/api/vacina")
public class VacinaController {
	private final VacinaService vacinaService;
	@Autowired
	private DoencaService doencaService;

	public VacinaController(VacinaService vacinaService) {
		super();
		this.vacinaService = vacinaService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Vacina>> listarTodos() {
		return new ResponseEntity<>(vacinaService.listarTodos(), HttpStatus.OK);
	}

	// @PostMapping()
	// public ResponseEntity<Vacina> salvar(@RequestBody Vacina vacina) {
	// 	return new ResponseEntity<>(vacinaService.salvar(vacina), HttpStatus.CREATED);
	// }

	@PostMapping()
	public ResponseEntity<Vacina> salvar(@RequestBody VacinaDTO vacinadto) {

		Vacina vacina = new Vacina();
		Doenca doenca = doencaService.acharPorNome(vacinadto.doencaNome);
		vacina.setDoenca(doenca);
		vacina.setDoses(vacinadto.doses);
		vacina.setIntervaloEntreDoses(vacinadto.intervaloEntreDoses);
		vacina.setTempoDeEficacia(vacinadto.tempoDeEficacia);
		vacina.setNome(vacinadto.nome);
		return new ResponseEntity<>(vacinaService.salvar(vacina), HttpStatus.CREATED);
	}
}
