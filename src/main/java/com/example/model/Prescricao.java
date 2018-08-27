package com.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "prescricao")
public class Prescricao extends AbstractEntity<Long>{

	@OneToOne
	@JoinColumn(name="id_paciente_fk")
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name="id_medico_fk")
	private Medico medico;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_prescricao", nullable = false, columnDefinition = "DATE")
	private LocalDate dataPrescricao;
	
	@JsonIgnore
	@OneToOne(cascade= CascadeType.ALL, mappedBy="prescricao")
	private Dispensacao dispensacao;
	
	@OneToMany
	@JoinTable(name="prescricao_medicamento", 
	joinColumns = @JoinColumn(name="id_prescrica_fk"),
	inverseJoinColumns = @JoinColumn(name="id_medicamento_fk"))
	private List<Medicamento> medicamentos = new ArrayList<>();
	
	public Prescricao() {
		super();
	}

	public Prescricao(Paciente paciente, Medico medico, LocalDate dataPrescricao, Dispensacao dispensacao) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.dataPrescricao = dataPrescricao;
		this.dispensacao = dispensacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public LocalDate getDataPrescricao() {
		return dataPrescricao;
	}

	public void setDataPrescricao(LocalDate dataPrescricao) {
		this.dataPrescricao = dataPrescricao;
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
