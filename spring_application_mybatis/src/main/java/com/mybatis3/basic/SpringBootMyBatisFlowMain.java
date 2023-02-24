package com.mybatis3.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.domain.Student;
@SpringBootApplication
public class SpringBootMyBatisFlowMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootMyBatisFlowMain.class, args);
		/*
		 * 1. SqlSession객체얻기
		 */
		SqlSession sqlSession = applicationContext.getBean(SqlSession.class);
		System.out.println("1. #### SqlSession객체얻기 : " + sqlSession);
		
		/*
		 * 2. SqlSession사용(CRUD) 
		 */
		
		/*
		 * com.mybatis3.dao.mapper.StudentBasicMapper를 namespace로 가지는 xml파일의 findStudent이름의 sql문
		 */
		Student student = sqlSession.selectOne("com.mybatis3.dao.mapper.StudentBasicMapper.findStudent", 1);
		System.out.println("#### findStudent : " + student);
		List<Student> studentList = sqlSession.selectList("com.mybatis3.dao.mapper.StudentBasicMapper.studentList");
		System.out.println("#### studentList : " + studentList);
	
	}
}
