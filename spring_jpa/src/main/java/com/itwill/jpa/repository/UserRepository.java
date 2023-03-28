package com.itwill.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);
	/*
	=
	List<User> getByName(String name);
	List<User> readByName(String name);
	List<User> searchByName(String name);
	*/
	
	List<User> findByEmail(String email);
	List<User> findByNameAndEmail(String name, String email);
	List<User> findByNameOrEmail(String name, String email);
}
