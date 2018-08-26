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
import com.example.model.Paciente;
import com.example.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Paciente> findAll()
	{
		return pacienteService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) 
	{
		Paciente paciente = pacienteService.findById(id);
		return paciente != null ? ResponseEntity.ok(paciente) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Paciente paciente, HttpServletResponse response)
	{
		Paciente pacienteSalvo = pacienteService.save(paciente);
		publisher.publishEvent(new ResourceCreateEvent(this, response, paciente.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> update(@PathVariable Long id, @Valid @RequestBody Paciente paciente)
	{
		Paciente pacienteSalvo = pacienteService.update(id, paciente);
		return ResponseEntity.ok(pacienteSalvo);
	}

}
