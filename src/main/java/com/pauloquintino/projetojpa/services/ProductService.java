package com.pauloquintino.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloquintino.projetojpa.entities.Product;
import com.pauloquintino.projetojpa.repositories.ProductRepository;

@Service //--> registra o OrderService como service do Spring para poder ser injetado com o Autowired em outras classes
public class ProductService {

	//injetando dependencia do Order Repository	
	@Autowired
	private ProductRepository repository;
	
	//metodo para retornar todos os pedidos do banco
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
