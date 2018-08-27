package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "dispensacao")
public class Dispensacao extends AbstractEntity<Long>{

	@OneToOne
	@JoinColumn(name="id_prescrica_fk")
	private Prescricao prescricao;
	
	@OneToOne
	@JoinColumn(name="id_medicamento_fk")
	private Medicamento medicamento;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_dispensacao", columnDefinition = "DATE")
	private LocalDate dataDispensacao;
	
	public Dispensacao() {
		super();
	}

	public Dispensacao(Prescricao prescricao, Medicamento medicamento, LocalDate dataDispensacao) {
		this.prescricao = prescricao;
		this.medicamento = medicamento;
		this.dataDispensacao = dataDispensacao;
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

	public LocalDate getDataDispensacao() {
		return dataDispensacao;
	}

	public void setDataDispensacao(LocalDate dataDispensacao) {
		this.dataDispensacao = dataDispensacao;
	}
}
