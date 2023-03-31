package com.jpa.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.relation.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
