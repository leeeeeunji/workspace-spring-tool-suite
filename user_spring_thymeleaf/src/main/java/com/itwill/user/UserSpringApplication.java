package com.itwill.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.user.mapper")
public class UserSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSpringApplication.class, args);
	}

}
