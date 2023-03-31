package com.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.relation.SpringJpaRelationApplicationTests;
import com.jpa.relation.entity.Product;
import com.jpa.relation.entity.Provider;

class ProviderRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void providerProductSaveRead() {
		
		Provider provider = new Provider();
		provider.setName("삼성출판사");
		providerRepository.save(provider);
		
		
		Product product1 = new Product();
		product1.setName("삼성");
		product1.setPrice(100000);
		product1.setStock(100);
		
		Product product2 = new Product();
		product2.setName("삼성출");
		product2.setPrice(9000);
		product2.setStock(50);
		
		/******* 연관 설정 Product -> Provider ********/
		product1.setProvider(provider);
		product2.setProvider(provider);
		/***********************************************/
		productRepository.save(product1);
		productRepository.save(product2);
		
		providerRepository.save(provider);
		
		
		System.out.println("Provider : " + providerRepository.findById(1L).get());
		System.out.println("Provider -> ProductList : " + providerRepository.findById(1L).get().getProductList());
		
		
		
		/****************** case1 CascadeType.PERSIST *******************/
		void providerProductSaveAndReadCascadeTypePERSIST() {
			
			Provider provider = new Provider("한빛미디어");
			
			Product product1 = new Product("파이썬", 10000, 20);
			Product product2 = new Product("AI", 15000, 30);
			Product product3 = new Product("코틀린", 20000, 5);
			
			product1.setProvider(provider);
			product2.setProvider(provider);
			product2.setProvider(provider);
			
			providerRepository.save(provider);
			
			
		}

		
	}
	

}
