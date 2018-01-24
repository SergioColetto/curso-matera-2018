package com.matera.cursoferias.response;

import java.util.UUID;

public class Carro {

	private String id;
	private String nome;
	private String cor;
	private Integer ano;

	public Carro() {
		this.setId(UUID.randomUUID().toString());
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
