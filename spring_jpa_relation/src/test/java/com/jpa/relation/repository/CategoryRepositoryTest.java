package com.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.relation.SpringJpaRelationApplicationTests;
import com.jpa.relation.entity.Category;
import com.jpa.relation.entity.Product;

class CategoryRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void categoryProductSaveAndRead() {
		/********** case1[ManyToOne] ***********
		Category category = new Category("C1", "컴퓨터");
		categoryRepository.save(category);
		
		Product product1 = Product.builder().name("EXCEL").price(500000).stock(10).build();
		Product product2 = Product.builder().name("WORD").price(500000).stock(10).build();
		Product product3 = Product.builder().name("POWERPOINT").price(500000).stock(10).build();
		
		product1.setCategory(category);
		product2.setCategory(category);
		product3.setCategory(category);
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		
		System.out.println("------------------ read --------------------");
		System.out.println("Category : " + categoryRepository.findById(1L).get());
		System.out.println("Category -> productList : " + categoryRepository.findById(1L).get().getProducts());
		********************************************/
		
		/********** case2[OneToMany] ***********/
		
		Product product1 = Product.builder().name("EXCEL").price(500000).stock(10).build();
		Product product2 = Product.builder().name("WORD").price(500000).stock(10).build();
		Product product3 = Product.builder().name("POWERPOINT").price(500000).stock(10).build();
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		Category category = new Category("C1", "컴퓨터");
		category.getProducts().add(product1);
		category.getProducts().add(product2);
		category.getProducts().add(product3);
		
		categoryRepository.save(category);
		
		
		System.out.println("------------------ read --------------------");
		System.out.println("Category : " + categoryRepository.findById(1L).get());
		System.out.println("Category -> productList : " + categoryRepository.findById(1L).get().getProducts());
		
	}

}
