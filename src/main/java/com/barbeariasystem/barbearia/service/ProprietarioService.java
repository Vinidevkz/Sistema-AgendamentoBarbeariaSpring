package com.barbeariasystem.barbearia.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbeariasystem.barbearia.entities.Proprietario;
import com.barbeariasystem.barbearia.exceptions.ResourceNotFoundException;
import com.barbeariasystem.barbearia.repositories.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository repository;
	
	//findall
	public List<Proprietario> findAll(){
		return repository.findAll();
	}
	
	//create
	public Proprietario insert(Proprietario Proprietario) {
		return repository.save(Proprietario);
	}
	
	//read
	public Proprietario findById(Long id) {
		Optional<Proprietario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//update
	public Proprietario update(Long id, Proprietario proprietario) {
	    try {
	        Proprietario entity = repository.getReferenceById(id);
	        updateData(entity, proprietario);
	        return repository.save(entity);
	    } catch (jakarta.persistence.EntityNotFoundException e) {
	        throw new ResourceNotFoundException(id);
	    }
	}
	
	private void updateData(Proprietario entity, Proprietario user) {
		entity.setNome(user.getNome());
		entity.setSobrenome(user.getSobrenome());
		entity.setEmail(user.getEmail());
		entity.setSenha(user.getSenha());
		entity.setTelefone(user.getTelefone());
		entity.setNascimento(user.getNascimento());
	    entity.setBarbearia(user.getBarbearia());
	    entity.setCpf(user.getCpf());
	    entity.setRg(user.getRg());
		
	}
	
	
	
	


}
