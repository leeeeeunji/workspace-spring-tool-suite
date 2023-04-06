package com.itwill.security.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itwill.security.user.domain.UsersAuthority;
import com.itwill.security.user.domain.Users;
import com.itwill.security.user.repository.UsersRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersService implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findUserByEmail(username).get();
	}

	public Optional<Users> findUser(String email) {
		return userRepository.findUserByEmail(email);
	}

	public Users save(Users user) {
		return userRepository.save(user);
	}

	public void addAuthority(Long userId, String authority) {
		Optional<Users> optionalUsers = userRepository.findById(userId);
		if (optionalUsers.isPresent()) {
			Users users = optionalUsers.get();
			UsersAuthority newRole = new UsersAuthority(users.getUserId(), authority);
			if (users.getAuthorities() == null) {
				HashSet<UsersAuthority> authorities = new HashSet<>();
				authorities.add(newRole);
				users.setAuthorities(authorities);
				save(users);
			} else if (!users.getAuthorities().contains(newRole)) {
				HashSet<UsersAuthority> authorities = new HashSet<>();
				authorities.addAll(users.getAuthorities());
				authorities.add(newRole);
				users.setAuthorities(authorities);
				save(users);
			}
		}
		/*
		userRepository.findById(userId).ifPresent(user -> {
			UsersAuthority newRole = new UsersAuthority(user.getUserId(), authority);
			if (user.getAuthorities() == null) {
				HashSet<UsersAuthority> authorities = new HashSet<>();
				authorities.add(newRole);
				user.setAuthorities(authorities);
				save(user);
			} else if (!user.getAuthorities().contains(newRole)) {
				HashSet<UsersAuthority> authorities = new HashSet<>();
				authorities.addAll(user.getAuthorities());
				authorities.add(newRole);
				user.setAuthorities(authorities);
				save(user);
			}
		});
		*/
	}

	public void removeAuthority(Long userId, String authority) {
		userRepository.findById(userId).ifPresent(user -> {
			if (user.getAuthorities() == null)
				return;
			UsersAuthority targetRole = new UsersAuthority(user.getUserId(), authority);
			if (user.getAuthorities().contains(targetRole)) {
				user.setAuthorities(user.getAuthorities().stream().filter(auth -> !auth.equals(targetRole))
						.collect(Collectors.toSet()));
				save(user);
			}
		});
	}

}
