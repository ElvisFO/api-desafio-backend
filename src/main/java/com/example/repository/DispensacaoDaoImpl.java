package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.AbstractDao;
import com.example.dao.DispensacaoDao;
import com.example.model.Dispensacao;

@Repository
public class DispensacaoDaoImpl extends AbstractDao<Dispensacao, Long> implements DispensacaoDao{

	@Override
	public List<Dispensacao> findByNome(String nome) {
		
		return createQuery("select d from Dispensacao d where d.nome like concat('%',?1,'%') ", nome);
	}
}
