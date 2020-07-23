package com.pauloquintino.projetojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloquintino.projetojpa.entities.User;

//como herda de JPARepository, não é necessário registrar como repository usando a annotation @Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
