package com.itwill.guest.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
class GuestDaoImplJdbcTemplateTest {
	@Autowired
	GuestDao guestDao;
	
	@Disabled
	@Test
	void testSelectAll() throws Exception {
		assertNotNull(guestDao.selectAll());
		assertNotEquals(guestDao.selectAll().size(), 0);
		System.out.println(guestDao.selectAll());
	}
	@Disabled
	@Test
	void testSelectByNo() {
		fail("Not yet implemented");
	}
	@Transactional
	@Test
	void testInsertGuest() throws Exception {
		int rowCount = guestDao.insertGuest(new Guest(0, "name", "2022", "email@email.com", "homepage", "title", "content"));
		assertEquals(1, rowCount);
	}
	@Disabled
	@Test
	void testUpdateGuest() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testDeleteGuest() {
		fail("Not yet implemented");
	}

}
