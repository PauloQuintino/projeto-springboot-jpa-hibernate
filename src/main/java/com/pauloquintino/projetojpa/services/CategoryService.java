package com.pauloquintino.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloquintino.projetojpa.entities.Category;
import com.pauloquintino.projetojpa.repositories.CategoryRepository;

@Service //--> registra o OrderService como service do Spring para poder ser injetado com o Autowired em outras classes
public class CategoryService {

	//injetando dependencia do Order Repository	
	@Autowired
	private CategoryRepository repository;
	
	//metodo para retornar todos os pedidos do banco
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
