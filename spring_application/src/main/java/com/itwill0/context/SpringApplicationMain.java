package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.product.ProductService;

public class SpringApplicationMain {

	public static void main(String[] args) {
		/*
		 * Spring Container객체 생성
		 * 	- applicationContext[BeanFactory]객체 생성
		 */
		
		/*
		 * 1. Spring Bean 설정파일을 읽어서 StringContainer객체 생성
		 */
		System.out.println("-----------------------ApplicationContext생성 시작-------------------------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill0/context/0.application_context.xml");
		System.out.println("------------------------ApplicationContext생성 끝--------------------------");

		/*
		 * 2. Spring Container객체[ApplicationContext객체]로부터 productService 아이디를 가진 객체 참조 얻기
		 */
		ProductService productService = (ProductService)applicationContext.getBean("productService");
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(111));
		System.out.println("-----------------singleton 객체-------------------");
		System.out.println(applicationContext.getBean("productService"));
		System.out.println(applicationContext.getBean("productService"));
	}

}
