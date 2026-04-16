package com.barbeariasystem.barbearia.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agendamentos")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "barbearia_id")
	private Barbearia barbearia;
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	private LocalDate data;
	private LocalTime hora;
	
	public Agendamento() {
		
	}
	
	
}
