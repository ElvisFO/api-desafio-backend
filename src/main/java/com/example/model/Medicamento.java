package com.example.model;

@SuppressWarnings("serial")
public class Medicamento extends AbstractEntity<Long>{

	private String nome;
	
	public Medicamento() {
		super();
	}

	public Medicamento(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
