package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.dto.VacinaDTO;
import com.techvacinabackend.model.Doenca;
import com.techvacinabackend.model.Vacina;
import com.techvacinabackend.service.DoencaService;
import com.techvacinabackend.service.VacinaService;

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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public ResponseEntity<List<Vacina>> listarTodos() {
		return new ResponseEntity<>(vacinaService.listarTodos(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<Vacina> retornarVacina(@PathVariable long id) {
		return new ResponseEntity<>(vacinaService.acharPorId(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
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
