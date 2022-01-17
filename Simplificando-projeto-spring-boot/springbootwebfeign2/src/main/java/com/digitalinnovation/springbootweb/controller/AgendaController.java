package com.digitalinnovation.springbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.springbootweb.Contrato.ConsumeApi;
import com.digitalinnovation.springbootweb.entidad.Contato;

@RestController
@RequestMapping("agenda")
public class AgendaController {
	
	@Autowired
	private ConsumeApi consumeApi;

	@GetMapping
	public Contato retornaContato() {
		return consumeApi.retornaContato(); 
	}
}
