package com.barbeariasystem.barbearia.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.barbeariasystem.barbearia.entities.Cliente;
import com.barbeariasystem.barbearia.repositories.AgendamentoRepository;
import com.barbeariasystem.barbearia.repositories.BarbeariaRepository;
import com.barbeariasystem.barbearia.repositories.ClienteRepository;
import com.barbeariasystem.barbearia.repositories.FuncionarioRepository;
import com.barbeariasystem.barbearia.repositories.ProprietarioRepository;


@Configuration

public class ConfigTest implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BarbeariaRepository barbeariaRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	/*
	@Autowired
	private HorarioRepository horarioRepository;
	*/
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;

		@Override
		public void run(String... args) throws Exception {
		    Cliente cliente1 = new Cliente(
		            "João",
		            "Silva",
		            "joao@gmail.com",
		            "123456",
		            "11999999999",
		            LocalDate.of(1995, 5, 21)
		    );
		
		    Cliente cliente2 = new Cliente(
		            "Maria",
		            "Oliveira",
		            "maria@gmail.com",
		            "abcdef",
		            "11988888888",
		            LocalDate.of(2000, 8, 10)
		    );
		
		    Cliente cliente3 = new Cliente(
		            "Carlos",
		            "Souza",
		            "carlos@gmail.com",
		            "senha123",
		            "11977777777",
		            LocalDate.of(1988, 12, 3)
		    );
		    
		    clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
			
		    
		}
	    
}
