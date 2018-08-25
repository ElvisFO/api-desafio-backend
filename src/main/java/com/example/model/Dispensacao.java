package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "DISPENSACAO")
public class Dispensacao extends AbstractEntity<Long>{
	
	@OneToOne
	@JoinColumn(name="prescricao_id")
	@MapsId
	private Prescricao prescricao;
	
	@OneToOne
	@JoinColumn(name="medicamento_id")
	@MapsId
	private Medicamento medicamento;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_de_dispensacao", nullable = false, columnDefinition = "DATE")
	private LocalDate data;
	
	public Dispensacao() {
		super();
	}

	public Dispensacao(Prescricao prescricao, Medicamento medicamento, LocalDate data) {
		this.prescricao = prescricao;
		this.medicamento = medicamento;
		this.data = data;
	}

	public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
