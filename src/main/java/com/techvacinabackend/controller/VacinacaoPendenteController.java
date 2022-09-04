package com.techvacinabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvacinabackend.model.VacinacaoPendente;
import com.techvacinabackend.service.DoencaService;
import com.techvacinabackend.service.VacinaService;
import com.techvacinabackend.service.ClienteService;
import com.techvacinabackend.service.VacinacaoPendenteService;
import com.techvacinabackend.model.Vacina;
import com.techvacinabackend.model.Doenca;
import com.techvacinabackend.model.Cliente;

import com.techvacinabackend.dto.VacinacaoPendenteDTO;

@RestController
@RequestMapping("/v1/api/vacinacaopendente")
public class VacinacaoPendenteController {
	private final VacinacaoPendenteService vacinacaoPendenteService;

	@Autowired
	private DoencaService doencaService;

	@Autowired
	private VacinaService vacinaService;

	@Autowired
	private ClienteService clienteService;

	public VacinacaoPendenteController(VacinacaoPendenteService vacinacaoPendenteService) {
		super();
		this.vacinacaoPendenteService = vacinacaoPendenteService;
	}
	
	@GetMapping("all")
	public ResponseEntity<List<VacinacaoPendente>> listarTodos() {
		return new ResponseEntity<>(vacinacaoPendenteService.listarTodos(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<VacinacaoPendente> salvar(@RequestBody VacinacaoPendenteDTO vacinacaoPDto) {

		VacinacaoPendente vacinacaoPendente = new VacinacaoPendente();
		Doenca doenca = doencaService.acharPorNome(vacinacaoPDto.doencaNome);
		Vacina vacina = vacinaService.acharPorNome(vacinacaoPDto.vacinaNome);
		Cliente cliente = clienteService.acharPorId(vacinacaoPDto.clienteId);
		vacinacaoPendente.setCliente(cliente);
		vacinacaoPendente.setDoenca(doenca);
		vacinacaoPendente.setVacina(vacina);
		vacinacaoPendente.setDose(vacinacaoPDto.dose);
		vacinacaoPendente.setDosesRestantes(vacinacaoPDto.dosesRestantes);
		vacinacaoPendente.setData(java.time.LocalDate.parse(vacinacaoPDto.data));
		return new ResponseEntity<>(vacinacaoPendenteService.salvar(vacinacaoPendente), HttpStatus.CREATED);
	}
}
