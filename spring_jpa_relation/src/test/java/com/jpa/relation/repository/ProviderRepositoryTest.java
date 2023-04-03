package com.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

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
Provider provider= new Provider("오릴리출판사");
		
		providerRepository.save(provider);
		
		Product product1=new Product("파이썬", 10000, 100);
		Product product2=new Product("머신러닝", 30000, 300);
		Product product3=new Product("인공지능", 89000, 50);
	
		/*****연관설정 Product-->Provider*****/
		product1.setProvider(provider);
		product2.setProvider(provider);
		product3.setProvider(provider);
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		System.out.println("Provider:"+providerRepository.findById(1L).get());
		System.out.println("Provider --> ProductList:"+providerRepository.findById(1L).get().getProductList());
		
	}
		
	/****************** case1 CascadeType.PERSIST *******************/
	@Transactional
	@Rollback(false)
	//@Test
	void providerProductSaveAndReadCascadeTypePERSIST() {
		
		Provider provider = new Provider("한빛미디어");
		
		Product product1 = new Product("파이썬", 10000, 20);
		Product product2 = new Product("AI", 15000, 30);
		Product product3 = new Product("코틀린", 20000, 5);
		
		product1.setProvider(provider);
		product2.setProvider(provider);
		product2.setProvider(provider);
		provider.getProductList().addAll(Lists.newArrayList(product1,product2,product3));
		
		providerRepository.save(provider);
			
		System.out.println(">>> ProductList[CascadeType.PERSIST]:"+providerRepository.findById(1L).get().getProductList());
		
	}
	
	/*******************case2 CascadeType.ALL************/
	@Test
	@Transactional
	@Rollback(false)
	void providerProductSaveAndReadCascadeTypeALL() {
		
		Provider provider = new Provider("한빛미디어");
		/************* CascadeType.PERSIST ******************/
		Product product1= new Product("파이썬", 10000, 20);
		Product product2= new Product("AI", 30000, 10);
		Product product3= new Product("코틀린", 70000,30);
		product1.setProvider(provider);
		product2.setProvider(provider);
		product3.setProvider(provider);
		provider.getProductList().addAll(Lists.newArrayList(product1,product2,product3));
		providerRepository.saveAndFlush(provider);
		
		System.out.println(">>> ProductList[CascadeType.PERSIST]:"+providerRepository.findById(1L).get().getProductList());
		Provider findProvider= providerRepository.findById(1L).get();
		
		/*************부모삭제[ CascadeType.DELETE ] ******************/
		//providerRepository.delete(findProvider);
		/****************************************************/
		
		/************* 자식삭제[ orphanRemoval = true ] ******************/
		List<Product> productList = findProvider.getProductList();
		productList.clear();
		/****************************************************/
		
		System.out.println(">>> ProductList[CascadeType.DELETE]:"+productRepository.findAll());
		
	}
	
	private Provider newProvider(String name) {
		Provider provider=new Provider(name);
		return provider;
	}
	private Product newProduct(String name,Integer price,Integer stock) {
		Product product=new Product(name,price,stock);
		return product;
	}
	

}
