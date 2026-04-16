package com.barbeariasystem.barbearia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbeariasystem.barbearia.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
