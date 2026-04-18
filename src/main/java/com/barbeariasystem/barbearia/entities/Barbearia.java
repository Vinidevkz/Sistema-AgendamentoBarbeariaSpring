package com.barbeariasystem.barbearia.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_barbearias")
public class Barbearia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToOne(mappedBy = "barbearia")
	private Proprietario proprietario;
	private LocalTime inicioFuncionamento;
	private LocalTime finalFuncionamento;
	
	@OneToMany(mappedBy = "barbearia")
	private List<Funcionario> funcionarios = new ArrayList<>();
	private Integer numeroFuncionarios = funcionarios.size();
	
	@OneToMany(mappedBy = "barbearia")
	private List<Horario> horarios = new ArrayList<>();
	
	@OneToMany(mappedBy = "barbearia")
	private List<Agendamento> agendamentos = new ArrayList<>();
	
	private String cnpj;
	
	public Barbearia() {
		
	}

	public Barbearia(Long id, String nome, Proprietario proprietario, LocalTime inicioFuncionamento,
			LocalTime finalFuncionamento, Integer numeroFuncionarios, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.proprietario = proprietario;
		this.inicioFuncionamento = inicioFuncionamento;
		this.finalFuncionamento = finalFuncionamento;
		this.numeroFuncionarios = numeroFuncionarios;
		this.cnpj = cnpj;
	}
	
	
	
}
