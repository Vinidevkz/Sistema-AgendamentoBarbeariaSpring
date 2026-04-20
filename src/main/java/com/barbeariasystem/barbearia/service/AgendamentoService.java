package com.barbeariasystem.barbearia.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbeariasystem.barbearia.entities.Agendamento;
import com.barbeariasystem.barbearia.exceptions.ResourceNotFoundException;
import com.barbeariasystem.barbearia.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;
	
	//findall
	public List<Agendamento> findAll(){
		return repository.findAll();
	}
	
	//create
	public Agendamento insert(Agendamento Agendamento) {
		return repository.save(Agendamento);
	}
	
	//read
	public Agendamento findById(Long id) {
		Optional<Agendamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//update
	public Agendamento update(Long id, Agendamento Agendamento) {
	    try {
	        Agendamento entity = repository.getReferenceById(id);
	        updateData(entity, Agendamento);
	        return repository.save(entity);
	    } catch (jakarta.persistence.EntityNotFoundException e) {
	        throw new ResourceNotFoundException(id);
	    }
	}
	
	private void updateData(Agendamento entity, Agendamento user) {
	    entity.setCliente(user.getCliente());
	    entity.setBarbearia(user.getBarbearia());
	    entity.setFuncionario(user.getFuncionario());
	    entity.setData(user.getData());
	    entity.setHora(user.getHora());
	}
	
	
	


}
