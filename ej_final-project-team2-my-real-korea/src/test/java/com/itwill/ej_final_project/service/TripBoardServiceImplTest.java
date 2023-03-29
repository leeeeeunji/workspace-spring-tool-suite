package com.itwill.ej_final_project.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@SpringBootTest
//@ComponentScan(basePackages = {"com.itwill.ej_final_project"})
class TripBoardServiceImplTest {
	
	@Autowired
	private TripBoardService tripBoardService;
	
	@Test
	void testSelectByTbNo() throws Exception {
		System.out.println(tripBoardService.selectByTbNo(1));
	}

}
