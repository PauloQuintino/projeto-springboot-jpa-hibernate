package com.pauloquintino.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloquintino.projetojpa.entities.Order;
import com.pauloquintino.projetojpa.repositories.OrderRepository;

@Service //--> registra o OrderService como service do Spring para poder ser injetado com o Autowired em outras classes
public class OrderService {

	//injetando dependencia do Order Repository	
	@Autowired
	private OrderRepository repository;
	
	//metodo para retornar todos os pedidos do banco
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
