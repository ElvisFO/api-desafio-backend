package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "medicamento")
public class Medicamento extends AbstractEntity<Long>{

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String nome;
	
	@JsonIgnore
	@ManyToMany(cascade= CascadeType.ALL, mappedBy="medicamentos")
	private List<Prescricao> prescricoes = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne(cascade= CascadeType.ALL, mappedBy="medicamento")
	private Dispensacao dispensacao;
	
	public Medicamento() {
		super();
	}

	public Medicamento(String nome, Dispensacao dispensacao) {
		this.nome = nome;
		this.dispensacao = dispensacao;
		//this.prescricao = prescricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Dispensacao getDispensacao() {
		return dispensacao;
	}

	public void setDispensacao(Dispensacao dispensacao) {
		this.dispensacao = dispensacao;
	}

	public List<Prescricao> getPrescricoes() {
		return prescricoes;
	}

	public void setPrescricoes(List<Prescricao> prescricoes) {
		this.prescricoes = prescricoes;
	}
}
