package com.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Prescricao extends AbstractEntity<Long>{

	private Paciente paciente;
	private LocalDate data;
	private List<Medicamento> medicamentos = new ArrayList<>();
	
	public Prescricao() {
		super();
	}

	public Prescricao(Paciente paciente, LocalDate data) {
		super();
		this.paciente = paciente;
		this.data = data;
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

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
}
