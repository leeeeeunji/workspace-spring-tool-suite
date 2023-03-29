package com.itwill.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.SpringJpaApplicationTests;
import com.itwill.jpa.entity.User;

class UserRepositoryTest extends SpringJpaApplicationTests {

	@Autowired
	public UserRepository userRepository;
	
	@Test
	void user_crud() {
		/********** insert ***********/
		User user1 = new User("조인성", "aaa1@gmail.com", LocalDateTime.now(), LocalDateTime.now());
		User user2 = new User("문성민", "aaa2@gmail.com", LocalDateTime.now(), LocalDateTime.now());
		User user3 = new User("유연석", "aaa3@gmail.com", LocalDateTime.now(), LocalDateTime.now());
		
		User saveUser1 = userRepository.save(user1);
		User saveUser2 = userRepository.save(user2);
		User saveUser3 = userRepository.save(user3);
		
		System.out.println(">>> saveUser1 : "+ saveUser1);
		System.out.println(">>> saveUser2 : "+ saveUser2);
		
		/********** find ***********/
		Optional<User> optionalUser1 = userRepository.findById(1L);
		if(optionalUser1.isPresent()) {
			User findUser1 = optionalUser1.get();
			System.out.println(">>> findUser1 : " + findUser1);
		}
		
		/********** findAll ***********/
		List<User> userList = userRepository.findAll();
		System.out.println(">>> userList : " + userList);
		
		/********** update ***********/
		Optional<User> optionalUser2 = userRepository.findById(3L);
		if(optionalUser2.isPresent()) {
			User findUser2 = optionalUser2.get();
			findUser2.setName("김김김");
			findUser2.setEmail("bbb1@gmail.com");
			findUser2.setUpdatedAt(LocalDateTime.now().plusDays(1L));
			User updatedUser2 = userRepository.save(findUser2);
			System.out.println(">>> updatedUser2 : " + updatedUser2);
		}
		
		/********** delete ***********/
		userRepository.deleteById(3L);
		userRepository.delete(saveUser1);
		
		userList = userRepository.findAll();
		System.out.println(">>> userList : " + userList);
	}
		
	@Test
	void select() {
		/*
		User user1 = new User("조인성", "aaa1@gmail.com", new Date(), LocalDateTime.now());
		User user2 = new User("문성민", "aaa2@gmail.com", new Date(), LocalDateTime.now());
		User user3 = new User("유연석", "aaa3@gmail.com", new Date(), LocalDateTime.now());
		
		User saveUser1 = userRepository.save(user1);
		User saveUser2 = userRepository.save(user2);
		User saveUser3 = userRepository.save(user3);
		
		*/
		System.out.println(">>> findByName : " + userRepository.findByName("조인성"));
		System.out.println(">>> findByEmail : " + userRepository.findByEmail("aaa3@gmail.com"));
		
		
		System.out.println(">>> findFirst2ByName : "
							+ userRepository.findFirst2ByName("김경호11"));
		System.out.println(">>> findTop2ByName : "
				+ userRepository.findTop2ByName("김경호11"));
		
		
		System.out.println(">>> findByIdAfter : "
				+ userRepository.findByIdAfter(7L));
		System.out.println(">>> findByIdBetween : "
				+ userRepository.findByIdBetween(7L, 12L));
		System.out.println(">>> findByCreatedAtGreaterThan : "
				+ userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
		System.out.println(">>> findByCreatedAtGreaterThanEqual : "
				+ userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusMinutes(10L)));
		
	}
}
