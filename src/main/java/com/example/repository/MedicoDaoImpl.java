package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.AbstractDao;
import com.example.dao.MedicoDao;
import com.example.model.Medico;

@Repository
public class MedicoDaoImpl extends AbstractDao<Medico, Long> implements MedicoDao{

	@Override
	public List<Medico> findByNome(String nome) {
		
		return createQuery("select m from Medico m where m.nome like concat('%',?1,'%') ", nome);
	}
}
