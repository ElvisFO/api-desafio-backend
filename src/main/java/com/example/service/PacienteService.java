package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.PacienteDao;
import com.example.model.Paciente;

@Service
public class PacienteService {

	@Autowired
	private PacienteDao pacienteDao;
	
	@Transactional(readOnly = false)
	public Paciente save(Paciente paciente)
	{
		return pacienteDao.save(paciente);
	}
	
	@Transactional(readOnly = false)
	public Paciente update(Long id, Paciente paciente)
	{
		Paciente pacienteData = pacienteDao.findById(id);
		this.updateData(pacienteData, paciente);
		return pacienteDao.update(pacienteData);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) 
	{
		pacienteDao.delete(id);
	}
	
	public Paciente findById (Long id)
	{
		return pacienteDao.findById(id);
	}
	
	public List<Paciente> findAll()
	{
		return pacienteDao.findAll();
	}
	
	private void updateData(Paciente pacienteData, Paciente pacienteBody)
	{
		pacienteData.setCpf(pacienteBody.getCpf());
		pacienteData.setDataNascimento(pacienteBody.getDataNascimento());
		pacienteData.setNome(pacienteBody.getNome());
	}
	
}
