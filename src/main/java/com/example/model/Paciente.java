package com.example.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "paciente")
public class Paciente extends AbstractEntity<Long>{

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Size(max = 11, min = 11)
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_nascimento", nullable = false, columnDefinition = "DATE")
	private LocalDate dataNascimento;
	
	@JsonIgnore
	@OneToOne(cascade= CascadeType.ALL, mappedBy="paciente")
	Prescricao prescricao;

	public Paciente() {
		super();
	}
	
	public Paciente(String nome, String cpf, LocalDate dataNascimento, Prescricao prescricao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.prescricao = prescricao;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
