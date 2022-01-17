package com.digitalinnovation.springbootweb.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class TestIntegrationController {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testIntegration() throws Exception {
		RequestBuilder requisicao = get("/test");
		MvcResult resultado = mvc.perform(requisicao).andReturn();
		
		assertEquals("Bem-vindo, Ale-default", resultado.getResponse().getContentAsString());
		
	}
	
	@Test
	public void testIntegrationComArgumento() throws Exception {
//		RequestBuilder requisicao = get("/test?nome=Alefuu");
//		MvcResult resultado = mvc.perform(requisicao).andReturn();
//		
//		assertEquals("Bem-vindo, Alefuu", resultado.getResponse().getContentAsString());
		
		mvc.perform(get("/test?nome=aledois"))
			.andExpect(content().string("Bem-vindo, aledois"));
		
	}
}
