package br.com.itexto.spring.services;

public interface Executor {
	
	void iniciar();
	
	void interpretar(String linha);
	
	void limpar();
	
}
