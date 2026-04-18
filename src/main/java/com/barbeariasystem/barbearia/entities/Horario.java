package com.barbeariasystem.barbearia.entities;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_horarios")
public class Horario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalTime horarioDisponivel;
	
	@ManyToOne
	@JoinColumn(name = "barbearia_id")
	private Barbearia barbearia;
	
}
