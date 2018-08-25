package com.example.dao;

import java.util.List;

import com.example.model.Medicamento;

public interface MedicamentoDao {

	Medicamento save(Medicamento medicamento);

	Medicamento update(Medicamento medicamento);

    void delete(Long id);

    Medicamento findById(Long id);

    List<Medicamento> findAll();
    
    List<Medicamento> findByNome(String nome);
}
