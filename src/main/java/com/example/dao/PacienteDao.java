package com.example.dao;

import java.util.List;

import com.example.model.Paciente;

public interface PacienteDao {

	Paciente save(Paciente paciente);

	Paciente update(Paciente paciente);

    void delete(Long id);

    Paciente findById(Long id);

    List<Paciente> findAll();
    
    List<Paciente> findByNome(String nome);
}
