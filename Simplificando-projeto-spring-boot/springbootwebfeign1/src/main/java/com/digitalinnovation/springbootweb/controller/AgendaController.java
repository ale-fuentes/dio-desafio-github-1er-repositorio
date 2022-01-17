package com.digitalinnovation.springbootweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.springbootweb.Contato;

@RestController
@RequestMapping("contato")
public class AgendaController {
	
	@GetMapping
	public Contato retornaContato() {
		return Contato.builder()
				.id(1L)
				.nome("Ale")
				.telefone("1230-0123")
				.build();
	}

}
