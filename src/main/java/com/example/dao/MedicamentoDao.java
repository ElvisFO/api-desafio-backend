package com.example.dao;

import java.util.List;

import com.example.model.Medicamento;

public interface MedicamentoDao {

	void save(Medicamento medicamento);

    void update(Medicamento medicamento);

    void delete(Long id);

    Medicamento findById(Long id);

    List<Medicamento> findAll();
    
    List<Medicamento> findByNome(String nome);
}
