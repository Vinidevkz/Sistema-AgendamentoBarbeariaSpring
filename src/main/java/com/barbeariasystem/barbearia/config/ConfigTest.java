package com.barbeariasystem.barbearia.config;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.barbeariasystem.barbearia.entities.Barbearia;
import com.barbeariasystem.barbearia.entities.Cliente;
import com.barbeariasystem.barbearia.entities.Funcionario;
import com.barbeariasystem.barbearia.entities.Proprietario;
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
	 * @Autowired private HorarioRepository horarioRepository;
	 */

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente("João", "Silva", "joao@gmail.com", "123456", "11999999999",
				LocalDate.of(1995, 5, 21));

		Cliente cliente2 = new Cliente("Maria", "Oliveira", "maria@gmail.com", "abcdef", "11988888888",
				LocalDate.of(2000, 8, 10));

		Cliente cliente3 = new Cliente("Carlos", "Souza", "carlos@gmail.com", "senha123", "11977777777",
				LocalDate.of(1988, 12, 3));

		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));

		Proprietario p1 = new Proprietario("João", "Silva", "joao.silva@email.com", "123456", "11999999999",
				LocalDate.of(1990, 5, 10), "12345678900", "12345678");

		Proprietario p2 = new Proprietario("Maria", "Oliveira", "maria.oliveira@email.com", "abcdef", "11988888888",
				LocalDate.of(1985, 8, 20), "98765432100", "87654321");

		Proprietario p3 = new Proprietario("Carlos", "Souza", "carlos.souza@email.com", "senha123", "11977777777",
				LocalDate.of(1992, 3, 15), "45678912300", "11223344");
		
		proprietarioRepository.saveAll(Arrays.asList(p1, p2, p3));

		Barbearia b1 = new Barbearia("Barbearia Alpha", p1, LocalTime.of(8, 0), LocalTime.of(18, 0), 0,
				"12.345.678/0001-00");

		Barbearia b2 = new Barbearia("Barbearia Beta", p2, LocalTime.of(9, 0), LocalTime.of(19, 0), 0,
				"98.765.432/0001-11");

		Barbearia b3 = new Barbearia("Barbearia Gamma", p3, LocalTime.of(10, 0), LocalTime.of(20, 0), 0,
				"11.222.333/0001-44");

		barbeariaRepository.saveAll(Arrays.asList(b1, b2, b3));
		
		p1.setBarbearia(b1);
		p2.setBarbearia(b2);
		p3.setBarbearia(b3);
		
		proprietarioRepository.saveAll(Arrays.asList(p1, p2, p3));

		Funcionario f1 = new Funcionario("Lucas", "Pereira", "lucas.pereira@email.com", "123456", b1, "11122233344",
				"12345678", "11999990000", LocalDate.of(1995, 2, 10));

		Funcionario f2 = new Funcionario("Ana", "Costa", "ana.costa@email.com", "abcdef", b2, "55566677788",
				"87654321", "11988880000", LocalDate.of(1998, 7, 25));

		Funcionario f3 = new Funcionario("Bruno", "Almeida", "bruno.almeida@email.com", "senha123", b3,
				"99988877766", "11223344", "11977770000", LocalDate.of(1993, 11, 5));
		
		Funcionario f4 = new Funcionario("Mariana", "Pereira", "mariana.pereira@email.com", "123456", b1, "11122233344",
				"12345678", "11999990000", LocalDate.of(1995, 2, 10));

		Funcionario f5 = new Funcionario("Hannah", "Costa", "hannah.costa@email.com", "abcdef", b2, "55566677788",
				"87654321", "11988880000", LocalDate.of(1998, 7, 25));

		Funcionario f6 = new Funcionario("Kayque", "Almeida", "kayque.almeida@email.com", "senha123", b3,
				"99988877766", "11223344", "11977770000", LocalDate.of(1993, 11, 5));

		funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4, f5, f6));
		
		
		
		
	}

}
