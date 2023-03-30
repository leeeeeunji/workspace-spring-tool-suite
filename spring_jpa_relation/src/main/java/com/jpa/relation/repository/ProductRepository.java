package com.jpa.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.relation.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
