package br.com.itexto.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import br.com.itexto.spring.services.Executor;
import br.com.itexto.spring.services.impl.ExecutorArquivo;

//@Configuration
public class Configuracao {
	
	@Value("${nomearquivo}")
	private String nomeArquivo;
	
	@Bean
	public Executor getExecutor() {
		ExecutorArquivo saida = new ExecutorArquivo();
		saida.setNomeArquivo(nomeArquivo);
		saida.iniciar();
		return saida;
	}
	
//	@Bean
//	public LeitorWeb getLeitorWeb(Executor executor) {
//		LeitorWeb leitor = new LeitorWeb();
//		leitor.setExecutor(executor);
//		return leitor;
//	}
	
}
