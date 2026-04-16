package com.barbeariasystem.barbearia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbeariasystem.barbearia.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
