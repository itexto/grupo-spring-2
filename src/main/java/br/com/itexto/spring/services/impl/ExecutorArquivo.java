package br.com.itexto.spring.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.itexto.spring.services.Executor;

@Profile("prod")
@Component
public class ExecutorArquivo implements Executor {
	
	/**
	 * E se eu quiser customizar este arquivo aqui?
	 */
	private File arquivo;
	
	@Value("{nomearquivo}")
	private String nomeArquivo;
	
	private FileOutputStream fos;
	
	@PostConstruct
	@Override
	public void iniciar() {
		this.arquivo = new File(System.getProperty("user.home") + "/" + this.nomeArquivo);
		if (arquivo.exists()) {
			arquivo.delete();
		}
		try {
			fos = new FileOutputStream(arquivo);
		} catch (IOException ex) {
			throw new RuntimeException("Opa! Erro grave aqui!");
		}
		
	}

	@Override
	public void interpretar(String linha) {
		try {
			fos.write(linha.getBytes());
		} catch (IOException ex) {
			
		}
		
	}

	@Override
	public void limpar() {
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException ex) {
				throw new RuntimeException("Algo muito triste aqui ao limpar recursos!");
			}
		}
		
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}



}
