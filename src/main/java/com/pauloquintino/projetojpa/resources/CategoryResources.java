package com.pauloquintino.projetojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauloquintino.projetojpa.entities.Category;
import com.pauloquintino.projetojpa.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {

	// injetando dependencia para o CategoryService
	@Autowired
	private CategoryService service;

	// metodo de reponse de uma requisição Web para retornar todos as categorias do
	// banco
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
