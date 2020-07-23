package com.pauloquintino.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloquintino.projetojpa.entities.User;
import com.pauloquintino.projetojpa.repositories.UserRepository;

@Service //--> registra o UserService como service do Spring para poder ser injetado com o Autowired em outras classes
public class UserService {

	//injetando dependencia do User Repository	
	@Autowired
	private UserRepository repository;
	
	//metodo para retornar todos os usuários do banco
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
