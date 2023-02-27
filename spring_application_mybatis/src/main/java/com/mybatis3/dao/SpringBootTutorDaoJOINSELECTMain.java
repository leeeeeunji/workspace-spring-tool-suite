package com.mybatis3.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.domain.Student;

@SpringBootApplication
@MapperScan(basePackages = "com.mybatis3.dao.mapper")
public class SpringBootTutorDaoJOINSELECTMain {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootTutorDaoJOINSELECTMain.class, args);
		TutorDao tutorDao=(TutorDao)appicationContext.getBean(TutorDao.class);
		System.out.println("---------findTutorByIdWithCourses------------------");
		System.out.println(tutorDao.findTutorByIdWithCourses(2));
		
		System.out.println("---------findStudentByIdWithCourses------------------");
		
		
		System.out.println("---------findStudentByIdWithAddressWithCourses-------");

	}

}
