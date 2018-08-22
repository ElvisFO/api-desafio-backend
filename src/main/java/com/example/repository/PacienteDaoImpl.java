package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.AbstractDao;
import com.example.dao.PacienteDao;
import com.example.model.Paciente;

@Repository
public class PacienteDaoImpl extends AbstractDao<Paciente, Long> implements PacienteDao{

	@Override
	public List<Paciente> findByNome(String nome) {
		
		return createQuery("select p from Paciente p where p.nome like concat('%',?1,'%') ", nome);
	}

}
