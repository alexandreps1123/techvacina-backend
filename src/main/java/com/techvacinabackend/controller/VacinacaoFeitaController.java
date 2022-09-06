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

import com.techvacinabackend.dto.VacinacaoFeitaDTO;
import com.techvacinabackend.model.Cliente;
import com.techvacinabackend.model.Doenca;
import com.techvacinabackend.model.LoteVacina;
import com.techvacinabackend.model.PostoDeSaude;
import com.techvacinabackend.model.Vacina;
import com.techvacinabackend.model.VacinacaoFeita;
import com.techvacinabackend.model.VacinacaoMaisRecente;
import com.techvacinabackend.model.VacinacaoPendente;
import com.techvacinabackend.service.ClienteService;
import com.techvacinabackend.service.DoencaService;
import com.techvacinabackend.service.LoteVacinaService;
import com.techvacinabackend.service.PostoDeSaudeService;
import com.techvacinabackend.service.VacinaService;
import com.techvacinabackend.service.VacinacaoFeitaService;
import com.techvacinabackend.service.VacinacaoMaisRecenteService;
import com.techvacinabackend.service.VacinacaoPendenteService;

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
	private LoteVacinaService loteVacinaService;

	@Autowired
	private VacinacaoMaisRecenteService vacinacaoMaisRecenteService;

	@Autowired
	private VacinacaoPendenteService vacinacaoPendenteService;

	@Autowired
	private PostoDeSaudeService postoDeSaudeService;

	public VacinacaoFeitaController(VacinacaoFeitaService vacinacaoFeitaService) {
		super();
		this.vacinacaoFeitaService = vacinacaoFeitaService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("all")
	public ResponseEntity<List<VacinacaoFeita>> listarTodos() {
		return new ResponseEntity<>(vacinacaoFeitaService.listarTodos(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("cliente/{id}")
	public ResponseEntity<List<VacinacaoFeita>> listarVacinacaoesFeitasPorCliente(@PathVariable long id) {
		return new ResponseEntity<>(vacinacaoFeitaService.acharPorCliente(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<VacinacaoFeita> salvar(@RequestBody VacinacaoFeitaDTO vacinacaoFDto) {

		VacinacaoFeita vacinacaoFeita = new VacinacaoFeita();
		Doenca doenca = doencaService.acharPorNome(vacinacaoFDto.doencaNome);
		Vacina vacina = vacinaService.acharPorNome(vacinacaoFDto.vacinaNome);
		Cliente cliente = clienteService.acharPorId(vacinacaoFDto.clienteId);
		LoteVacina lote = loteVacinaService.acharPorId(vacinacaoFDto.loteId);
		PostoDeSaude posto = postoDeSaudeService.acharPorId(vacinacaoFDto.postoId);
		vacinacaoFeita.setCliente(cliente);
		vacinacaoFeita.setDoenca(doenca);
		vacinacaoFeita.setVacina(vacina);
		vacinacaoFeita.setLote(lote);
		vacinacaoFeita.setDose(vacinacaoFDto.dose);
		vacinacaoFeita.setPosto(posto);
		vacinacaoFeita.setData(java.time.LocalDate.parse(vacinacaoFDto.data));
		ResponseEntity<VacinacaoFeita> responseEntity = new ResponseEntity<>(vacinacaoFeitaService.salvar(vacinacaoFeita), HttpStatus.CREATED);
		if (responseEntity.getStatusCode() == HttpStatus.CREATED) {

			// Exclui vacinação pendente que esteja associada.
			VacinacaoPendente vacinacaoPendente = vacinacaoPendenteService.acharPorClienteIdEDoencaEVacina(
				cliente.getId(), doenca.getNome(), vacina.getNome());
			if (vacinacaoPendente != null) {
				vacinacaoPendenteService.apagar(vacinacaoPendente);
			}

			// Atualiza registro de vacinação mais recente do cliente.
			VacinacaoMaisRecente vacinacaoMaisRecente = vacinacaoMaisRecenteService
				.acharPorClienteENomeDoenca(vacinacaoFDto.clienteId, vacinacaoFDto.doencaNome);
			if (vacinacaoMaisRecente == null) {
				// Se não houver registro de vacinação mais recente, cria-se aqui.
				vacinacaoMaisRecente = new VacinacaoMaisRecente();
				vacinacaoMaisRecente.setCliente(cliente);
				vacinacaoMaisRecente.setDoenca(doenca);
			}
			vacinacaoMaisRecente.setVacinacao(vacinacaoFeita);
			// Calcular data prevista da próxima vacinação.
			Long tempoDeEficacia = vacinacaoFeita.getVacina().getTempoDeEficacia();
			java.time.LocalDate dataProximaVacina = vacinacaoFeita.getData().plusDays(tempoDeEficacia);
			vacinacaoMaisRecente.setDataPrevistaProxima(dataProximaVacina);
			vacinacaoMaisRecenteService.salvar(vacinacaoMaisRecente);
		}
		return responseEntity;
	}
}
