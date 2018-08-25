package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "MEDICO")
public class Medico extends AbstractEntity<Long>{
	
	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String nome;
	
	public Medico() {
		super();
	}

	public Medico(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
