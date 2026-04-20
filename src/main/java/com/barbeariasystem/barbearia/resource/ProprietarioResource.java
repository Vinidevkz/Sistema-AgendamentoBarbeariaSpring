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

import com.barbeariasystem.barbearia.entities.Proprietario;
import com.barbeariasystem.barbearia.service.ProprietarioService;

@RestController
@RequestMapping(value = "/proprietarios")
public class ProprietarioResource {

	@Autowired
	private ProprietarioService service;

	@GetMapping
	public ResponseEntity<List<Proprietario>> findAll() {
		List<Proprietario> proprietarios = service.findAll();
		return ResponseEntity.ok().body(proprietarios);
	}

	@PostMapping
	public ResponseEntity<Proprietario> create(@RequestBody Proprietario proprietario) {
		proprietario = service.insert(proprietario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proprietario.getId())
				.toUri();

		return ResponseEntity.created(uri).body(proprietario);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Proprietario> read(@PathVariable Long id) {
		Proprietario proprietario = service.findById(id);
		return ResponseEntity.ok().body(proprietario);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Proprietario> update(@PathVariable Long id, @RequestBody Proprietario proprietario) {
		proprietario = service.update(id, proprietario);
		return ResponseEntity.ok().body(proprietario);

	}

	//

}
