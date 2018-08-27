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
@Table(name = "medicamento")
public class Medicamento extends AbstractEntity<Long>{

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String nome;
	
	
	//@OneToOne(cascade= CascadeType.ALL)
	//private Prescricao prescricao;
	
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

	/*public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}*/
}
