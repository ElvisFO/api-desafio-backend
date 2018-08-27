package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "medico")
public class Medico extends AbstractEntity<Long>{
	
	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String nome;
	
	@JsonIgnore
	@OneToOne(cascade= CascadeType.ALL, mappedBy="medico")
	private Prescricao prescricao;
	
	public Medico() {
		super();
	}

	public Medico(String nome, Prescricao prescricao) {
		this.nome = nome;
		this.prescricao = prescricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}
}
