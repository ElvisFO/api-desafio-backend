package com.example.dao;

import java.util.List;

import com.example.model.Prescricao;

public interface PrescricaoDao {

	void save(Prescricao prescricao);

    void update(Prescricao prescricao);

    void delete(Long id);

    Prescricao findById(Long id);

    List<Prescricao> findAll();
    
    List<Prescricao> findByNome(String nome);
}
