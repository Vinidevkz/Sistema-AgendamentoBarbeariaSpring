package com.barbeariasystem.barbearia.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "barbearia_id")
	private Barbearia barbearia;
	private String cpf;
	private String rg;
	private String telefone;
	private LocalDate nascimento;
	
	public Funcionario() {
		
	}

	public Funcionario(Long id, String nome, String sobrenome, String email, String senha, Barbearia barbearia,
	String cpf, String rg, String telefone, LocalDate nascimento) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.barbearia = barbearia;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.nascimento = nascimento;
	}
	
	
	//

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Barbearia getBarbearia() {
		return barbearia;
	}

	public void setBarbearia(Barbearia barbearia) {
		this.barbearia = barbearia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	//

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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
	
	//

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", senha="
				+ senha + ", barbearia=" + barbearia + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone
				+ ", nascimento=" + nascimento + "]";
	}
	
	//
	
	
	
	
	
	
}
