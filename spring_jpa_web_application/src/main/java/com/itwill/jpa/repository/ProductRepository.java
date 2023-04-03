package com.itwill.jpa.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
