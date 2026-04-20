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

import com.barbeariasystem.barbearia.entities.Barbearia;
import com.barbeariasystem.barbearia.entities.Horario;
import com.barbeariasystem.barbearia.exceptions.ResourceNotFoundException;
import com.barbeariasystem.barbearia.repositories.BarbeariaRepository;
import com.barbeariasystem.barbearia.service.HorarioService;

@RestController
@RequestMapping(value = "/horarios")
public class HorarioResource {

	@Autowired
	private HorarioService service;
	
	@Autowired
	private BarbeariaRepository barbeariaRepository;

	@GetMapping
	public ResponseEntity<List<Horario>> findAll() {
		List<Horario> horarios = service.findAll();
		return ResponseEntity.ok().body(horarios);
	}
	
    @GetMapping(value = "/barbearia/{barbeariaId}")
    public ResponseEntity<List<Horario>> findAllByBarbearia(@PathVariable Long barbeariaId) {
        List<Horario> horarios = service.findAllByBarbearia(barbeariaId);
        return ResponseEntity.ok(horarios);
    }

	@PostMapping
	public ResponseEntity<Horario> create(@RequestBody Horario Horario) {
		Horario = service.insert(Horario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Horario.getId())
				.toUri();

		return ResponseEntity.created(uri).body(Horario);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Horario> read(@PathVariable Long id) {
		Horario Horario = service.findById(id);
		return ResponseEntity.ok().body(Horario);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Horario> update(@PathVariable Long id, @RequestBody Horario Horario) {
		Horario = service.update(id, Horario);
		return ResponseEntity.ok().body(Horario);
	}

	//

}
