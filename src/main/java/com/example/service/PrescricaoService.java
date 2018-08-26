package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.PrescricaoDao;
import com.example.model.Prescricao;

@Service
public class PrescricaoService {

	@Autowired
	private PrescricaoDao prescricaoDao;
	
	@Transactional(readOnly = false)
	public Prescricao save(Prescricao prescricao)
	{
		return prescricaoDao.save(prescricao);
	}
	
	@Transactional(readOnly = false)
	public Prescricao update(Long id, Prescricao prescricao)
	{
		Prescricao prescricaoData = prescricaoDao.findById(id);
		this.updateData(prescricaoData, prescricao);
		return prescricaoDao.update(prescricaoData);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) 
	{
		prescricaoDao.delete(id);
	}
	
	public Prescricao findById (Long id)
	{
		return prescricaoDao.findById(id);
	}
	
	public List<Prescricao> findAll()
	{
		return prescricaoDao.findAll();
	}
	
	private void updateData(Prescricao prescricaoData, Prescricao prescricaoBody)
	{
		prescricaoData.setPaciente(prescricaoBody.getPaciente());
		prescricaoData.setData(prescricaoBody.getData());
		prescricaoData.setDispensacao(prescricaoBody.getDispensacao());
		prescricaoData.setMedicamentos(prescricaoBody.getMedicamentos());
	}
	
}
