package com.example.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MedicamentoDao;
import com.example.model.Medicamento;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoDao medicamentoDao;
	
	@Transactional(readOnly = false)
	public Medicamento save(Medicamento medicamento)
	{
		return medicamentoDao.save(medicamento);
	}
	
	@Transactional(readOnly = false)
	public Medicamento update(Long id, Medicamento medicamento)
	{
		Medicamento medicamentoData = medicamentoDao.findById(id);
		this.updateData(medicamentoData, medicamento);
		return medicamentoDao.update(medicamentoData);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) 
	{
		medicamentoDao.delete(id);
	}
	
	public Medicamento findById (Long id)
	{
		return medicamentoDao.findById(id);
	}
	
	public List<Medicamento> findAll()
	{
		return medicamentoDao.findAll();
	}
	
	private void updateData(Medicamento medicamentoData, Medicamento medicamentoBody)
	{
		medicamentoData.setNome(medicamentoBody.getNome());
		//medicamentoData.setDispensacao(medicamentoBody.getDispensacao());
		//medicamentoData.setPrescricao(medicamentoBody.getPrescricao());
	}
	
}
