package br.com.itexto.spring.factory;

import br.com.itexto.spring.services.Executor;
import br.com.itexto.spring.services.impl.EchoExecutor;
import br.com.itexto.spring.services.impl.ExecutorArquivo;

public class FactoryExecutor {
	
	
	
	public Executor criar(String tipo, String...parametros) {
		
		switch(tipo) {
			case "echo":
				return new EchoExecutor();
			case "arquivo":
				ExecutorArquivo result = new ExecutorArquivo();
				result.setNomeArquivo(parametros[0]);
				return result;
			default:
				return null;
		}
			
		
	}
	
}
