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
import com.example.model.Medico;
import com.example.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {
	
	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Medico> findAll()
	{
		return medicoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) 
	{
		Medico medico = medicoService.findById(id);
		return medico != null ? ResponseEntity.ok(medico) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Medico medico, HttpServletResponse response)
	{
		Medico medicoSalvo = medicoService.save(medico);
		publisher.publishEvent(new ResourceCreateEvent(this, response, medico.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(medicoSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Medico> update(@PathVariable Long id, @Valid @RequestBody Medico medico)
	{
		Medico medicoSalvo = medicoService.update(id, medico);
		return ResponseEntity.ok(medicoSalvo);
	}

}
