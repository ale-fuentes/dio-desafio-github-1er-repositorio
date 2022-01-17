package com.digitalinnovation.springbootweb.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.digitalinnovation.springbootweb.controller.TestController;

public class TestUnitController {

	@Test
	public void testUnit() {
		TestController controller = new TestController();
		String resultado = controller.saudacao("ale");
		
		assertEquals("Bem-vindo, ale", resultado);
	}
}
