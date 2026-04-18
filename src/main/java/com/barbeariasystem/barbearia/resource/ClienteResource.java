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

import com.barbeariasystem.barbearia.entities.Cliente;
import com.barbeariasystem.barbearia.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = service.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		cliente = service.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> read(@PathVariable Long id) {
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente); 
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
		cliente = service.update(id, cliente);
		return ResponseEntity.ok().body(cliente);
		
	}
	
	//
	

}
