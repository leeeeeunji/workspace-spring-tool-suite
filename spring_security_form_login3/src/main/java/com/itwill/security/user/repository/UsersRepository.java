package com.itwill.security.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.security.user.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUserByEmail(String email);

}
