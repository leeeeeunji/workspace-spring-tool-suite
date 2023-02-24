package com.itwill.user.dao.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.itwill.user.dao.jdbc.User;
import com.itwill.user.dao.jdbc.UserDao;

@SpringBootApplication//현재 위치와 하위 몽땅 검사
@SpringBootTest
class UserDaoImplTest {
	@Autowired
	ApplicationContext applicaContext;
	
	@Autowired
	UserDao userDao;
	
	@Test
	void contextLoad() {
		System.out.println(applicaContext);
	}
	@Disabled
	@Test
	void testCreate() throws Exception {
		User user = new User("test1111", "test1111", "테스트1111", "test1111@test.com");
		assertEquals(userDao.create(user), 1);
	}
	
	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented"); 
	}
	@Disabled
	@Test
	void testRemove() {
		fail("Not yet implemented");
	}
	//@Disabled
	@Test
	void testFindUser() throws Exception {
		User user = userDao.findUser("test1111");
		assertNotNull(user);
		assertNotNull(user.getUserId());
		assertNotNull(user.getPassword());
		assertNotNull(user.getName());
		assertNotNull(user.getEmail());
		System.out.println(user);
	}
	@Disabled
	@Test
	void testFindUserList() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}

}
