package com.barbeariasystem.barbearia.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.barbeariasystem.barbearia.entities.Agendamento;
import com.barbeariasystem.barbearia.service.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService service;

	@GetMapping
	public ResponseEntity<List<Agendamento>> findAll() {
		List<Agendamento> Agendamentos = service.findAll();
		return ResponseEntity.ok().body(Agendamentos);
	}

	@PostMapping
	public ResponseEntity<Agendamento> create(@RequestBody Agendamento Agendamento) {
		Agendamento = service.insert(Agendamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Agendamento.getId())
				.toUri();

		return ResponseEntity.created(uri).body(Agendamento);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Agendamento> read(@PathVariable Long id) {
		Agendamento Agendamento = service.findById(id);
		return ResponseEntity.ok().body(Agendamento);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Agendamento> update(@PathVariable Long id, @RequestBody Agendamento Agendamento) {
		Agendamento = service.update(id, Agendamento);
		return ResponseEntity.ok().body(Agendamento);

	}

	//

}
