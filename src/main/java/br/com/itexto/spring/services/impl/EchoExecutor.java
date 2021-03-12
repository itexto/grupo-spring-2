package br.com.itexto.spring.services.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.itexto.spring.services.Executor;

@Primary
@Component
public class EchoExecutor implements Executor {

	@Override
	public void iniciar() {
		// nada de útil aqui
		
	}

	@Override
	public void interpretar(String linha) {
		System.out.println("Echo... " + linha);
		
	}

	@Override
	public void limpar() {
		// nada de útil aqui também
		
	}

}
