package com.barbeariasystem.barbearia.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariasystem.barbearia.dto.ControleDTO;
import com.barbeariasystem.barbearia.service.ControleService;

@RestController
@RequestMapping(value = "/controle")
public class ControleResource {
	
	@Autowired
	private ControleService service;

	@GetMapping("/{id}/funcionarios-disponiveis")
	public ResponseEntity<List<ControleDTO>> funcionariosDisponiveis(
	        @PathVariable Long id,
	        @RequestParam String data,
	        @RequestParam String hora) {

	    List<ControleDTO> list = service
	        .buscarFuncionariosDisponiveis(id, data, hora);

	    return ResponseEntity.ok(list);
	}
}
