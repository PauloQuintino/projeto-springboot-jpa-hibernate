package com.pauloquintino.projetojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloquintino.projetojpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
