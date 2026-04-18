package com.barbeariasystem.barbearia.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbeariasystem.barbearia.entities.Cliente;
import com.barbeariasystem.barbearia.exceptions.ResourceNotFoundException;
import com.barbeariasystem.barbearia.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	//findall
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	//create
	public Cliente insert(Cliente cliente) {
		return repository.save(cliente);
	}
	
	//read
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//update
	public Cliente update(Long id, Cliente cliente) {
		try {
			Cliente entity = repository.getReferenceById(id);
			updateData(entity, cliente);
			return repository.save(entity);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Cliente entity, Cliente user) {
		entity.setNome(user.getNome());
		entity.setSobrenome(user.getSobrenome());
		entity.setEmail(user.getEmail());
		entity.setSenha(user.getSenha());
		entity.setTelefone(user.getTelefone());
		entity.setNascimento(user.getNascimento());
		
		
	}
	
	
	
	


}
