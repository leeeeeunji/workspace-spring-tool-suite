package com.mybatis3.basic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
스프링 부트 메인 어플리케이션에 @MapperScan을 이용해 
스프링 부트가 @Mapper가 붙은 MyBatis 매퍼를 스캔하여 
빈으로 등록할 수 있도록 한다.
 */
@SpringBootApplication
public class SpringBootMyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootMyBatisMapperInterfaceFlowMain.class, args);
		/*
		 * 1. StudentMapper객체얻기
		 */
		
		System.out.println("1. #### StudentMapper객체얻기:");
		/*
		 * 2. StudentMapper사용(CRUD)
		 */
		
		/*
		 * com.mybatis3.dao.mapper.StudentBasicMapper를 namespace로가지는 xml파일의
		 * findStudentById이름의 sql문
		 */
	
		System.out.println("#### findStudent:" );

		
		System.out.println("#### studentList:" );
	
	
	}
}













