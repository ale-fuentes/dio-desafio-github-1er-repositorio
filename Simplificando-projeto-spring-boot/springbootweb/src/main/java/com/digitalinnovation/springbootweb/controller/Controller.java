package com.digitalinnovation.springbootweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String message() {
		return "Nosso primeiro messagem do project Spring Boot Web";
	}
}
