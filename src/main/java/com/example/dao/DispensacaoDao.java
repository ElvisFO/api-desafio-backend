package com.example.dao;

import java.util.List;


import com.example.model.Dispensacao;

public interface DispensacaoDao {

	Dispensacao save(Dispensacao dispensacao);

	Dispensacao update(Dispensacao dispensacao);

    void delete(Long id);

    Dispensacao findById(Long id);

    List<Dispensacao> findAll();
    
    List<Dispensacao> findByNome(String nome);
}
