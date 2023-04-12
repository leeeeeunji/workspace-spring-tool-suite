package com.itwill.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.security.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserid(String userid);

}