package com.example.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dispensacao;
import com.example.service.DispensacaoService;

@RestController
@RequestMapping("/dispensacoes")
public class DispensacaoResource {
	
	@Autowired
	private DispensacaoService dispensacaoService;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Dispensacao dispensacao, HttpServletResponse response)
	{
		this.dispensacaoService.save(dispensacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
