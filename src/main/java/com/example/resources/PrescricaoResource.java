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
import com.example.model.Prescricao;
import com.example.service.PrescricaoService;

@RestController
@RequestMapping("/prescricoes")
public class PrescricaoResource {
	
	@Autowired
	private PrescricaoService prescicoesService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Prescricao> findAll()
	{
		return prescicoesService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) 
	{
		Prescricao prescricao = prescicoesService.findById(id);
		return prescricao != null ? ResponseEntity.ok(prescricao) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Prescricao prescricao, HttpServletResponse response)
	{
		Prescricao prescricaoSalva = prescicoesService.save(prescricao);
		publisher.publishEvent(new ResourceCreateEvent(this, response, prescricaoSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(prescricaoSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Prescricao> update(@PathVariable Long id, @Valid @RequestBody Prescricao prescricao)
	{
		Prescricao prescricaoSalva = prescicoesService.update(id, prescricao);
		return ResponseEntity.ok(prescricaoSalva);
	}

}
