package com.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRESCRICAO")
public class Prescricao extends AbstractEntity<Long>{

	@NotNull
	@Column(name= "paciente_id", nullable = false)
	private Paciente paciente;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_de_prescricao", nullable = false, columnDefinition = "DATE")
	private LocalDate data;
	
	@OneToOne(cascade= CascadeType.ALL, mappedBy="prescricao")
	private Dispensacao dispensacao;
	
	@ManyToMany
	@JoinTable(name="PRESCRICAO_MEDICAMENTO", 
	joinColumns = @JoinColumn(name="prescricao_id"),
	inverseJoinColumns = @JoinColumn(name="medicamento_id"))
	private List<Medicamento> medicamentos = new ArrayList<>();
	
	public Prescricao() {
		super();
	}

	public Prescricao(Paciente paciente, LocalDate data, Dispensacao dispensacao) {
		super();
		this.paciente = paciente;
		this.data = data;
		this.dispensacao = dispensacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Dispensacao getDispensacao() {
		return dispensacao;
	}

	public void setDispensacao(Dispensacao dispensacao) {
		this.dispensacao = dispensacao;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
}
