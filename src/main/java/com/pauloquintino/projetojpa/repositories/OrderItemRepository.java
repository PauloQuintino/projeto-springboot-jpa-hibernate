package com.pauloquintino.projetojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloquintino.projetojpa.entities.OrderItem;

//como herda de JPARepository, não é necessário registrar como repository usando a annotation @Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
}
