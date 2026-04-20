package com.barbeariasystem.barbearia.service;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbeariasystem.barbearia.entities.Barbearia;
import com.barbeariasystem.barbearia.entities.Horario;
import com.barbeariasystem.barbearia.exceptions.ResourceNotFoundException;
import com.barbeariasystem.barbearia.repositories.BarbeariaRepository;
import com.barbeariasystem.barbearia.repositories.HorarioRepository;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository repository;
	
	@Autowired
	private BarbeariaRepository barbeariaRepository;
	
	//findall
	public List<Horario> findAll(){
		return repository.findAll();
	}
	
	//create
	public Horario insert(Horario horario) {

	    Barbearia barbearia = barbeariaRepository.findById(horario.getBarbearia().getId())
	        .orElseThrow(() -> new ResourceNotFoundException(horario.getBarbearia().getId()));

	    LocalTime horarioDisponivel = horario.getHorarioDisponivel();

	    if (horarioDisponivel.isBefore(barbearia.getInicioFuncionamento()) ||
	        horarioDisponivel.isAfter(barbearia.getFinalFuncionamento())) {

	        throw new RuntimeException("Horário fora do funcionamento da barbearia");
	    }

	    return repository.save(horario);
	}
	
	//read
	public Horario findById(Long id) {
		Optional<Horario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//find by barbearia
    public List<Horario> findAllByBarbearia(Long barbeariaId) {
        Barbearia barbearia = barbeariaRepository.findById(barbeariaId)
            .orElseThrow(() -> new ResourceNotFoundException(barbeariaId));

        return repository.findByBarbeariaId(barbearia.getId());
    }
	
	//update
	public Horario update(Long id, Horario Horario) {
	    try {
	        Horario entity = repository.getReferenceById(id);
	        updateData(entity, Horario);
	        return repository.save(entity);
	    } catch (jakarta.persistence.EntityNotFoundException e) {
	        throw new ResourceNotFoundException(id);
	    }
	}
	
	private void updateData(Horario entity, Horario user) {
	    entity.setHorarioDisponivel(user.getHorarioDisponivel());
	    entity.setBarbearia(user.getBarbearia());
	}
	
	
	
	


}
