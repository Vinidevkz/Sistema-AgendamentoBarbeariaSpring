package com.barbeariasystem.barbearia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbeariasystem.barbearia.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
