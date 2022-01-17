package com.digitalinnovation.springbootsimplifica;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Livro livro = factory.getBean(Livro.class);
		livro.setNome("Ale - miracle");
		livro.setCodigo("D$#D33");
		Autor autor = factory.getBean(Autor.class);
		autor.setNome("Alefuuu");

		livro.exibir();
		((AbstractApplicationContext) factory).close();
	}

}
