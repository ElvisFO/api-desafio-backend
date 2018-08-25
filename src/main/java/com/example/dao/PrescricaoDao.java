package com.example.dao;

import java.util.List;

import com.example.model.Prescricao;

public interface PrescricaoDao {

	Prescricao save(Prescricao prescricao);

	Prescricao update(Prescricao prescricao);

    void delete(Long id);

    Prescricao findById(Long id);

    List<Prescricao> findAll();
    
    List<Prescricao> findByNome(String nome);
}
