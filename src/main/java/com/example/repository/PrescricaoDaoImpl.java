package com.example.repository;

import java.util.List;

import com.example.dao.AbstractDao;
import com.example.dao.PrescricaoDao;
import com.example.model.Prescricao;

public class PrescricaoDaoImpl extends AbstractDao<Prescricao, Long> implements PrescricaoDao{

	@Override
	public List<Prescricao> findByNome(String nome) {
		
		return createQuery("select m from Medicamento m where m.nome like concat('%',?1,'%') ", nome);
	}

}
