package com.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.relation.SpringJpaRelationApplicationTests;
import com.jpa.relation.entity.Product;
import com.jpa.relation.entity.ProductDetail;
import com.jpa.relation.entity.Provider;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests {


	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductDetailRepository productDetailRepository;
	
	@Autowired
	ProviderRepository providerRepository;
	
	
	@Test
	void productSaveAndUpdate() {
		Product product=Product.builder()
						.name("JPA일주일만하면")
						.price(3000)
						.stock(1000)
						.build();
		productRepository.save(product);
		
		product.setName("JSP하루만하면");
		productRepository.save(product);
		
		
	}
	
	@Test
	void productProductDetailSaveRead() {
		
			Product product=new Product();
			product.setName("스프링시큐리디변경");
			product.setPrice(80000);
			product.setStock(500);
			productRepository.save(product);
			
			ProductDetail productDetail=new ProductDetail();
			productDetail.setDescription("아주좋은책이여요!!!");
			productDetail.setProduct(product);
			productDetailRepository.save(productDetail);
			
			System.out.println("-----------------read--------------------");
			System.out.println("Product:"+productRepository.findById(1L).get());
			System.out.println("Product --> ProductDetail:"+productRepository.findById(1L).get().getProductDetail());
			
			
		}
	
	@Test
	void productProviderSaveRead() {
		
		Provider provider = new Provider();
		provider.setName("삼성출판사");
		providerRepository.save(provider);
		
		
		Product product=new Product();
		product.setName("삼성출판사변경");
		product.setPrice(100000);
		product.setStock(100);
		product.setProvider(provider);
		productRepository.save(product);
		
		
		System.out.println("product : " + productRepository.findById(2L).get());
		System.out.println("product -> Provider : " + productRepository.findById(2L).get().getProvider());
		
		
	}
	

}
