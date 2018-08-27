package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DispensacaoDao;
import com.example.dao.MedicamentoDao;
import com.example.dao.PrescricaoDao;
import com.example.model.Medicamento;
import com.example.model.Prescricao;
import com.example.model.Dispensacao;

@Service
public class DispensacaoService {

	@Autowired
	private DispensacaoDao dispensacaoDao;
	
	@Autowired
	private PrescricaoDao prescricaoDao;
	
	@Autowired
	private MedicamentoDao medicamentoDao;
	
	
	@Transactional(readOnly = false)
	public void save(Dispensacao dispensacao)
	{
		createAndPersist(dispensacao);
	}
	
	public List<Dispensacao> findAll()
	{
		return dispensacaoDao.findAll();
	}
	
	private void createAndPersist(Dispensacao dispensacaoBody)
	{
		Dispensacao dispensacaoData = new Dispensacao();
		
		Prescricao prescricao = prescricaoDao.findById(dispensacaoBody.getPrescricao().getId());
		//dispensacaoData.setDataDispensacao(dispensacaoBody.getDataDispensacao());
		
		for(Medicamento medicamento : prescricao.getMedicamentos()) {
			
			Medicamento m = medicamentoDao.findById(medicamento.getId());
			
			if(m != null) {
				dispensacaoData.setPrescricao(prescricao);
				dispensacaoData.setMedicamento(m);
				dispensacaoData.setDataDispensacao(LocalDate.now());
				
				dispensacaoDao.save(dispensacaoData);	
				dispensacaoData = new Dispensacao();	
			}
		}
	}
}
