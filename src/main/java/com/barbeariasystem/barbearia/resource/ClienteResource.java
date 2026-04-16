package com.barbeariasystem.barbearia.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.barbeariasystem.barbearia.entities.Cliente;
import com.barbeariasystem.barbearia.repositories.ClienteRepository;

public class ClienteResource {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente create(Cliente usuario) {
		return repository.save(usuario);
	}
	
	public Optional<Cliente> read(Long id) {
		return repository.findById(id);
	}
	
	public Cliente update(Long id, Cliente usuario) {
		try {
			Cliente entity = repository.getReferenceById(id);
			updateData(entity, usuario);
			return repository.save(entity);
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
