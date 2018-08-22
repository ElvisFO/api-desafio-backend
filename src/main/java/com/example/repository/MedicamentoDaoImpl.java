package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.AbstractDao;
import com.example.dao.MedicamentoDao;
import com.example.model.Medicamento;

@Repository
public class MedicamentoDaoImpl extends AbstractDao<Medicamento, Long> implements MedicamentoDao{

	@Override
	public List<Medicamento> findByNome(String nome) {
		
		return createQuery("select m from Medicamento m where m.nome like concat('%',?1,'%') ", nome);
	}
}
