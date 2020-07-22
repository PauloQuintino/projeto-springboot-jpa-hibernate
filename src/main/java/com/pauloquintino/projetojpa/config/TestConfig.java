package com.pauloquintino.projetojpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pauloquintino.projetojpa.entities.User;
import com.pauloquintino.projetojpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	//Spring associa a instancia de UserRepository ao TestConfig
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//Tudo que for implementado aqui será executado quando a aplicação for executada
		
		//instanciando objetos que vão popular o banco de testes
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		//salvando os objetos no banco
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}