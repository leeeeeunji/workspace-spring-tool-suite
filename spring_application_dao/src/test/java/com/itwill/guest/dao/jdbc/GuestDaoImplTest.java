package com.itwill.guest.dao.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.guest.dao.jdbc.Guest;
import com.itwill.guest.dao.jdbc.GuestDao;
@SpringBootApplication
@SpringBootTest
class GuestDaoImplTest {

	@Autowired
	GuestDao guestDao;
	
	@Disabled //Test원치 않을 때 사용
	@Test
	void testSelectAll() throws Exception {
		assertNotEquals(guestDao.selectAll(), null);
		//guestDao.selectAll()은 null이 아니다 = true, null = false
		assertNotEquals(guestDao.selectAll().size(), 0);
		//0이 아니다 = true, 0명 false
		
		System.out.println(guestDao.selectAll().size());
		System.out.println(guestDao.selectAll());
		
	}
	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		assertNull(guestDao.selectByNo(19112126));
		assertNotNull(guestDao.selectByNo(196));
		assertEquals(guestDao.selectByNo(196).getGuest_name(), "요셉짱");
		System.out.println(guestDao.selectByNo(196));
		//assertEquals는 두 값이 같은 지를 비교하는 단정문
		//assertSame은 두 객체가 동일한 객체인지 주소값으로 비교하는 단정문
	}
	@Transactional
	@Test
	void testInsertGuest() throws Exception {
		Guest insertGuest = new Guest(0, "하하하", null, "aaa@naver.com", "test.com", "하하하", "컨텐트");
		assertEquals(guestDao.insertGuest(insertGuest), 1);
	}
	
	@Disabled
	@Test
	void testUpdateGuest() throws Exception {
		Guest updateGuest = new Guest(0, "테스트수정", null, "change@naver.com", "change.com", "타이틀수정", "컨텐트수정");
		int updateRowCount = guestDao.updateGuest(updateGuest);
		if(updateRowCount != 1) {
			fail("update 실패!");
		}
	}

}
