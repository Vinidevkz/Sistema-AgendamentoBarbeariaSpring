package com.barbeariasystem.barbearia.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbeariasystem.barbearia.entities.Agendamento;
import com.barbeariasystem.barbearia.entities.Barbearia;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByBarbeariaAndDataAndHora(
            Barbearia barbearia,
            LocalDate data,
            LocalTime hora
        );
}
