package com.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.relation.SpringJpaRelationApplicationTests;
import com.jpa.relation.entity.Category;
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
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
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
		
		/******* 연관 설정 Provide -> Product ********/
		//provider.getProductList().addAll(Arrays.asList(product1,  product2));
		Provider provider2 = providerRepository.findById(1L).get();
		
		providerRepository.save(provider2);
		
		
		System.out.println("product : " + productRepository.findById(2L).get());
		System.out.println("product -> Provider : " + productRepository.findById(2L).get().getProvider());
		
		
	}
	
	@Test
	void productCategorySaveAndRead() {
		/********** case1[ManyToOne] ***********/
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
		System.out.println("Product : " + productRepository.findById(3L).get());
		System.out.println("Product -> Category : " + productRepository.findById(3L).get().getCategory());
		
		
		
		
	}

}
