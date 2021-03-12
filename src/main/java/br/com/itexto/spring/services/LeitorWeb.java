package br.com.itexto.spring.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeitorWeb {
	
	private final Executor executor;
	
	@Autowired
	public LeitorWeb(Executor executor) {
		this.executor = executor;
	}
	
	public void processar(String endereco) {
        InputStream input = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        
        try { 
            URL url = new URL(endereco);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            input = conexao.getInputStream();
            reader = new InputStreamReader(input);
            bufferedReader = new BufferedReader(reader);
            String linha = null;
            while ((linha = bufferedReader.readLine()) != null) {
                executor.interpretar(linha);
            }
            input.close();
            reader.close();
            bufferedReader.close();


        } catch (IOException ex) {
            throw new RuntimeException("Erro grave!", ex);
        } 
    }
	


}
