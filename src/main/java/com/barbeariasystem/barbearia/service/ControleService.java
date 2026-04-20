package com.barbeariasystem.barbearia.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbeariasystem.barbearia.dto.ControleDTO;
import com.barbeariasystem.barbearia.entities.Agendamento;
import com.barbeariasystem.barbearia.entities.Barbearia;
import com.barbeariasystem.barbearia.entities.Funcionario;
import com.barbeariasystem.barbearia.exceptions.ResourceNotFoundException;
import com.barbeariasystem.barbearia.repositories.AgendamentoRepository;
import com.barbeariasystem.barbearia.repositories.BarbeariaRepository;

@Service
public class ControleService {

	@Autowired
	private BarbeariaRepository barbeariaRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<ControleDTO> buscarFuncionariosDisponiveis(
	        Long barbeariaId, String dataStr, String horaStr) {

	    Barbearia barbearia = barbeariaRepository.findById(barbeariaId)
	        .orElseThrow(() -> new ResourceNotFoundException(barbeariaId));

	    LocalDate data = LocalDate.parse(dataStr);
	    LocalTime hora = LocalTime.parse(horaStr);

	    List<Funcionario> funcionarios = barbearia.getFuncionarios();

	    List<Agendamento> ocupados = agendamentoRepository.findByBarbeariaAndDataAndHora(barbearia, data, hora);

	    Set<Long> idsOcupados = ocupados.stream()
	        .map(a -> a.getFuncionario().getId())
	        .collect(Collectors.toSet());

	    return funcionarios.stream().map(f -> new ControleDTO(f.getId(),f.getNome(), !idsOcupados.contains(f.getId()))).toList();
	}
	


}
