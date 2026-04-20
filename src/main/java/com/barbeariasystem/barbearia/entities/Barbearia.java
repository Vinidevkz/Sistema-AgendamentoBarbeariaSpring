package com.barbeariasystem.barbearia.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public Barbearia(String nome, Proprietario proprietario, LocalTime inicioFuncionamento,
			LocalTime finalFuncionamento, Integer numeroFuncionarios, String cnpj) {
		this.nome = nome;
		this.proprietario = proprietario;
		this.inicioFuncionamento = inicioFuncionamento;
		this.finalFuncionamento = finalFuncionamento;
		this.numeroFuncionarios = numeroFuncionarios;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public LocalTime getInicioFuncionamento() {
		return inicioFuncionamento;
	}

	public void setInicioFuncionamento(LocalTime inicioFuncionamento) {
		this.inicioFuncionamento = inicioFuncionamento;
	}

	public LocalTime getFinalFuncionamento() {
		return finalFuncionamento;
	}

	public void setFinalFuncionamento(LocalTime finalFuncionamento) {
		this.finalFuncionamento = finalFuncionamento;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barbearia other = (Barbearia) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Barbearia [id=" + id + ", nome=" + nome + ", proprietario=" + proprietario + ", inicioFuncionamento="
				+ inicioFuncionamento + ", finalFuncionamento=" + finalFuncionamento + ", funcionarios=" + funcionarios
				+ ", numeroFuncionarios=" + numeroFuncionarios + ", horarios=" + horarios + ", agendamentos="
				+ agendamentos + ", cnpj=" + cnpj + "]";
	}
	
	
	
	
	
}
