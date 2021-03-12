package br.com.itexto.spring.services;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manipulador {
	
	@Autowired
	private LeitorWeb leitor;
	
	@PostConstruct
	public void iniciar() {
		leitor.processar("https://www.google.com");
	}

}
