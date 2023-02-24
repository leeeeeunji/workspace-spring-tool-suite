package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.product.ProductService;

@SpringBootApplication
@ComponentScan(basePackages = "com.itwill.product")
public class SpringbootApplicationMain {

	public static void main(String[] args) {
		System.out.println("----------------------ApplicationContext생성 시작-------------------------");
		ApplicationContext applicationContext = SpringApplication.run(SpringbootApplicationMain.class, args);
		System.out.println("-----------------------ApplicationContext생성 끝--------------------------");
		ProductService productService =
		(ProductService)applicationContext.getBean("productService");
		 
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(111));
		 

	}

}
