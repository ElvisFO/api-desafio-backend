package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MedicoDao;
import com.example.model.Medico;

@Service
public class MedicoService {

	@Autowired
	private MedicoDao medicoDao;
	
	@Transactional(readOnly = false)
	public Medico save(Medico medico)
	{
		return medicoDao.save(medico);
	}
	
	@Transactional(readOnly = false)
	public Medico update(Long id, Medico medico)
	{
		Medico medicoData = medicoDao.findById(id);
		
		if(medicoData == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		this.updateData(medicoData, medico);
		return medicoDao.update(medicoData);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) 
	{
		medicoDao.delete(id);
	}
	
	public Medico findById (Long id)
	{
		return medicoDao.findById(id);
	}
	
	public List<Medico> findAll()
	{
		return medicoDao.findAll();
	}
	
	private void updateData(Medico medicoData, Medico medicoBody)
	{
		medicoData.setNome(medicoBody.getNome());
	}
	
}
