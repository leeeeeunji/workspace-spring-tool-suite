package com.itwill.guest.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootApplication
@SpringBootTest
class GuestDaoImplMyBatisTest {
	@Autowired
	private GuestDao guestDao;
	
	@Test
	void init() {
		System.out.println(guestDao);
	}
	
	@Test
	void testSelectAll() {
		
	}

	
	void testSelectByNo() {
		fail("Not yet implemented");
	}

	@Transactional
	@Test
	void testInsertGuest() {
		fail("Not yet implemented");
	}

	
	void testUpdateGuest() {
		fail("Not yet implemented");
	}

	
	void testDeleteGuest() {
		fail("Not yet implemented");
	}

}
