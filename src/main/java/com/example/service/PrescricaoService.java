package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MedicamentoDao;
import com.example.dao.MedicoDao;
import com.example.dao.PacienteDao;
import com.example.dao.PrescricaoDao;
import com.example.model.Medicamento;
import com.example.model.Medico;
import com.example.model.Paciente;
import com.example.model.Prescricao;

@Service
public class PrescricaoService {

	@Autowired
	private PrescricaoDao prescricaoDao;
	
	@Autowired
	private PacienteDao pacienteDao;
	
	@Autowired
	private MedicamentoDao medicamentoDao;
	
	@Autowired
	private MedicoDao medicoDao;
	
	@Transactional(readOnly = false)
	public Prescricao save(Prescricao prescricao)
	{
		Prescricao prescricaoData = this.createData(prescricao);
		return prescricaoDao.save(prescricaoData);
	}
	
	@Transactional(readOnly = false)
	public Prescricao update(Long id, Prescricao prescricao)
	{
		Prescricao prescricaoData = prescricaoDao.findById(id);
		
		if(prescricao != null) {
			this.updateData(prescricaoData, prescricao);
			return prescricaoDao.update(prescricaoData);
		}
		return null;
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
		Paciente paciente = pacienteDao.findById(prescricaoBody.getPaciente().getId());
		Medico medico = medicoDao.findById(prescricaoBody.getMedico().getId());

		prescricaoData.setPaciente(paciente);
		prescricaoData.setMedico(medico);
		prescricaoData.setDataPrescricao(prescricaoBody.getDataPrescricao());
		
		prescricaoData.getMedicamentos().clear();
	
		for(Medicamento medicamento : prescricaoBody.getMedicamentos()) {
			
			Medicamento m = medicamentoDao.findById(medicamento.getId());
			
			if(m != null) {
				prescricaoData.getMedicamentos().add(m);
			}
		}
	}
	
	private Prescricao createData(Prescricao prescricaoBody)
	{
		Prescricao prescricaoData = new Prescricao();
		
		Paciente paciente = pacienteDao.findById(prescricaoBody.getPaciente().getId());
		Medico medico = medicoDao.findById(prescricaoBody.getMedico().getId());

		prescricaoData.setPaciente(paciente);
		prescricaoData.setMedico(medico);
		prescricaoData.setDataPrescricao(prescricaoBody.getDataPrescricao());
		
		for(Medicamento medicamento : prescricaoBody.getMedicamentos()) {
			
			Medicamento m = medicamentoDao.findById(medicamento.getId());
			
			if(m != null) {
				prescricaoData.getMedicamentos().add(m);
			}
		}
		
		return prescricaoData;
	}
}
