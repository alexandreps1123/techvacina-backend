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

import com.techvacinabackend.model.VacinacaoFeita;
import com.techvacinabackend.model.Cliente;
import com.techvacinabackend.model.Doenca;
import com.techvacinabackend.model.Vacina;
import com.techvacinabackend.model.VacinacaoPendente;
import com.techvacinabackend.service.ClienteService;
import com.techvacinabackend.service.DoencaService;
import com.techvacinabackend.service.VacinaService;
import com.techvacinabackend.service.VacinacaoFeitaService;
import com.techvacinabackend.service.VacinacaoPendenteService;
import com.techvacinabackend.dto.VacinacaoFeitaDTO;

@RestController
@RequestMapping("/v1/api/vacinacaofeita")
public class VacinacaoFeitaController {
	private final VacinacaoFeitaService vacinacaoFeitaService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private VacinaService vacinaService;

	@Autowired
	private DoencaService doencaService;

	@Autowired
	private VacinacaoPendenteService vacinacaoPendenteService;

	public VacinacaoFeitaController(VacinacaoFeitaService vacinacaoFeitaService) {
		super();
		this.vacinacaoFeitaService = vacinacaoFeitaService;
	}
	
	@GetMapping()
	public ResponseEntity<List<VacinacaoFeita>> listarTodos() {
		return new ResponseEntity<>(vacinacaoFeitaService.listarTodos(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<VacinacaoFeita> salvar(@RequestBody VacinacaoFeitaDTO vacinacaoFDto) {

		VacinacaoFeita vacinacaoFeita = new VacinacaoFeita();
		Doenca doenca = doencaService.acharPorNome(vacinacaoFDto.doencaNome);
		Vacina vacina = vacinaService.acharPorNome(vacinacaoFDto.vacinaNome);
		Cliente cliente = clienteService.acharPorId(vacinacaoFDto.clienteId);
		vacinacaoFeita.setCliente(cliente);
		vacinacaoFeita.setDoenca(doenca);
		vacinacaoFeita.setVacina(vacina);
		vacinacaoFeita.setDose(vacinacaoFDto.dose);
		vacinacaoFeita.setData(java.time.LocalDate.parse(vacinacaoFDto.data));
		ResponseEntity<VacinacaoFeita> responseEntity = new ResponseEntity<>(vacinacaoFeitaService.salvar(vacinacaoFeita), HttpStatus.CREATED);
		if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
			VacinacaoPendente vacinacaoPendente = vacinacaoPendenteService.acharPorClienteIdEDoencaEVacina(
				cliente.getId(), doenca.getNome(), vacina.getNome());
			vacinacaoPendenteService.apagar(vacinacaoPendente);
		}
		return responseEntity;
	}
}
