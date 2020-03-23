package com.fr.adaming.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.dto.NiveauDto;
import com.fr.adaming.dto.NiveauDtoCreate;
import com.fr.adaming.dto.ResponseDto;

@RequestMapping(path = "/niveau")
public interface INiveauController {

	@PostMapping
	public ResponseEntity<ResponseDto> create(@Valid @RequestBody NiveauDto dto);

	@PutMapping
	public ResponseEntity<ResponseDto> update(@Valid @RequestBody NiveauDtoCreate dto);

	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseDto> findById(@PathVariable(name = "id",required=false) Integer id);

	@GetMapping(path = "/all")
	public ResponseEntity<ResponseDto> findAll();

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseDto> delete(@PathVariable(name = "id") int id);

	@GetMapping(path = "/classe/{idNiveau}")
	public ResponseEntity<ResponseDto> findClasseByNiveau(@PathVariable(name = "idNiveau") int id);
}
