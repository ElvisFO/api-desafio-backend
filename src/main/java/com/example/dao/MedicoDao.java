package com.example.dao;

import java.util.List;

import com.example.model.Medico;

public interface MedicoDao {

	void save(Medico medico);

    void update(Medico medico);

    void delete(Long id);

    Medico findById(Long id);

    List<Medico> findAll();
    
    List<Medico> findByNome(String nome);
}
