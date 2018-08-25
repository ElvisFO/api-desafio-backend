package com.example.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.ResourceCreateEvent;
import com.example.model.Medicamento;
import com.example.service.MedicamentoService;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoResource {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Medicamento> findAll()
	{
		return medicamentoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) 
	{
		Medicamento medicamento = medicamentoService.findById(id);
		return medicamento != null ? ResponseEntity.ok(medicamento) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Medicamento medicamento, HttpServletResponse response)
	{
		Medicamento medicamentoSalvo = medicamentoService.save(medicamento);
		publisher.publishEvent(new ResourceCreateEvent(this, response, medicamento.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(medicamentoSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Medicamento> update(@PathVariable Long id, @Valid @RequestBody Medicamento medicamento)
	{
		Medicamento MedicamentoSalvo = medicamentoService.update(id, medicamento);
		return ResponseEntity.ok(MedicamentoSalvo);
	}

}
