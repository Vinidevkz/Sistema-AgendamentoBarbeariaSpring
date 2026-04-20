package com.barbeariasystem.barbearia.entities;

import java.time.LocalTime;
import java.util.Objects;

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
	
	public Horario() {
		
	}

	public Horario(Long id, LocalTime horarioDisponivel, Barbearia barbearia) {
		super();
		this.id = id;
		this.horarioDisponivel = horarioDisponivel;
		this.barbearia = barbearia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getHorarioDisponivel() {
		return horarioDisponivel;
	}

	public void setHorarioDisponivel(LocalTime horarioDisponivel) {
		this.horarioDisponivel = horarioDisponivel;
	}

	public Barbearia getBarbearia() {
		return barbearia;
	}

	public void setBarbearia(Barbearia barbearia) {
		this.barbearia = barbearia;
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
		Horario other = (Horario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", horarioDisponivel=" + horarioDisponivel + ", barbearia=" + barbearia + "]";
	}
	
	
	
}
