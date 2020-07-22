package com.pauloquintino.projetojpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauloquintino.projetojpa.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	//metodo de reponse de uma requisição Web
	@GetMapping
	public ResponseEntity<User> findAll(){
		//teste
		User user = new User(1L, "Paulo", "teste@gmail.com", "99999999", "123456");
		return ResponseEntity.ok().body(user);
	}
	
}
