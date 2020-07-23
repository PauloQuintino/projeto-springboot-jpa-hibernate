package com.pauloquintino.projetojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloquintino.projetojpa.entities.Category;

//como herda de JPARepository, não é necessário registrar como repository usando a annotation @Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
