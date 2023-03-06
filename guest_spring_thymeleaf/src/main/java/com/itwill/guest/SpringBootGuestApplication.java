package com.itwill.guest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.guest.mapper")
public class SpringBootGuestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGuestApplication.class, args);
	}

}
