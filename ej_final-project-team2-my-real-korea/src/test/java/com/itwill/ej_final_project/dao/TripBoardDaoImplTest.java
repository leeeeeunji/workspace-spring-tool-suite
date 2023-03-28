package com.itwill.ej_final_project.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ej_final_project.dto.TripBoard;

@SpringBootApplication
@SpringBootTest
@MapperScan(basePackages = "com.itwill.ej_final_project.mapper")
class TripBoardDaoImplTest {

	@Autowired
	private TripBoardDao tripBoardDao;
	
	@Test
	void testInsertTripBoard() throws Exception {
		int rowCount = tripBoardDao.insertTripBoard(new TripBoard(0, "테스트제목", "테스트내용", new Date(), 0, 1, 5, "테스트사진1.png", new Date(), new Date(), "무계획", "아무나다좋아", 1, "user1"));
		assertEquals(rowCount, 1);
	}
	
	@Test
	void testselectByTbNo() throws Exception {
		assertNotNull(tripBoardDao.selectByTbNo(1));
		System.out.println(tripBoardDao.selectByTbNo(1));
	}

}
