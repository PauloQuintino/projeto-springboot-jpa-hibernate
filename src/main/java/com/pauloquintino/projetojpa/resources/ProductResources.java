package com.pauloquintino.projetojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauloquintino.projetojpa.entities.Product;
import com.pauloquintino.projetojpa.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

	// injetando dependencia para o ProductService
	@Autowired
	private ProductService productService;
	
//	@Autowired
//	private CategoryService categoryService;

	// metodo de reponse de uma requisição Web para retornar todos as categorias do
	// banco
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
