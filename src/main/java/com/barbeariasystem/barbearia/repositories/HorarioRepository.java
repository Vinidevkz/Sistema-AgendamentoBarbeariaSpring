package com.barbeariasystem.barbearia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbeariasystem.barbearia.entities.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
	List<Horario> findByBarbeariaId(Long barbeariaId);
}
