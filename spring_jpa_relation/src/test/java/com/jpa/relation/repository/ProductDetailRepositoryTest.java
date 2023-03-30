package com.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.relation.SpringJpaRelationApplicationTests;
import com.jpa.relation.entity.Product;
import com.jpa.relation.entity.ProductDetail;

class ProductDetailRepositoryTest extends SpringJpaRelationApplicationTests {

	@Autowired
	ProductDetailRepository productDetailRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void productDetailProductSaveRead() {
		Product product = new Product();
		product.setName("스프링시큐리티");
		product.setPrice(80000);
		product.setStock(500);
		productRepository.save(product);
		
		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setDescription("아주좋은책이에요!");
		productDetail.setProduct(product);
		productDetailRepository.save(productDetail);
		
		
		System.out.println("----- read ------");
		System.out.println(">>> ProductDetail : " + productDetailRepository.findById(2L).get());
		System.out.println(">>> ProductDetail : " + productDetailRepository.findById(2L).get().getProductId());
		
	}

}
