package com.barbeariasystem.barbearia.resource;

import java.net.URI;

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
	
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		cliente = service.create(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> read(@PathVariable Long id) {
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente); 
	}
	
	@PutMapping(value = "/{id}")
	public Cliente update(Long id, Cliente usuario) {
		try {
			Cliente entity = service.getReferenceById(id);
			updateData(entity, usuario);
			return service.save(entity);
		}catch(RuntimeException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//
	
	private void updateData(Cliente entity, Cliente user) {
		entity.setNome(user.getNome());
		entity.setSobrenome(user.getSobrenome());
		entity.setEmail(user.getEmail());
		entity.setSenha(user.getSenha());
		entity.setTelefone(user.getTelefone());
		entity.setNascimento(user.getNascimento());
		
		
	}
}
