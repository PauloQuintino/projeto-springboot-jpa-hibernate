package com.pauloquintino.projetojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauloquintino.projetojpa.entities.Order;
import com.pauloquintino.projetojpa.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

	// injetando dependencia para o Service
	@Autowired
	private OrderService service;

	// metodo de reponse de uma requisição Web para retornar todos os usuários do
	// banco
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
