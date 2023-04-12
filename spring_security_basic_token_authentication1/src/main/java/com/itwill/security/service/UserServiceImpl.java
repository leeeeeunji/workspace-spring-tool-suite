package com.itwill.security.service;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.security.entity.User;
import com.itwill.security.repository.UserRepository;
import com.security.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	public UserRepository userRepository;
	public PasswordEncoder passwordEncoder;
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserDto create(UserDto userDto) {
		User user=null;
		if (userDto.getRole().equalsIgnoreCase("admin")) {
			Set<String> roleSet=  new HashSet<>();
			roleSet.add("ROLE_ADMIN");
			user = User.builder().userid(userDto.getUserid()).name(userDto.getName()).password(passwordEncoder.encode(userDto.getPassword()))
					.roles(roleSet).build();
		} else {
			Set<String> roleSet= new HashSet<>();
			roleSet.add("ROLE_USER");
			user = User.builder().userid(userDto.getUserid()).name(userDto.getName()).password(passwordEncoder.encode(userDto.getPassword()))
					.roles(roleSet).build();
		}

		User savedUser = userRepository.save(user);
		UserDto savedUserDto=UserDto.builder()
							.id(user.getId())
							.userid(savedUser.getUserid())
							.password(savedUser.getPassword())
							.name(savedUser.getName())
							.build();
		return savedUserDto;
	}

	
	@Override
	public UserDto view(Long id) throws RuntimeException {
		// TODO Auto-generated method stub
		User user=userRepository.findById(id).get();
		
		UserDto userDto= UserDto.builder()
						.id(user.getId())
						.userid(user.getUserid())
						.password(user.getPassword())
						.name(user.getName())
						.roles(user.getRoles())
						.build();
		return userDto;
	}

	@Override
	public UserDto update(UserDto userDto) throws RuntimeException {
		User user=userRepository.findByUserid(userDto.getUserid());
		if (userDto.getRole() !=null || userDto.getRole().equalsIgnoreCase("admin")) {
			Set<String> roleSet=  new HashSet<>();
			roleSet.add("ROLE_ADMIN");
			//user.setId(userDto.getId());
			user.setName(userDto.getName());
			//user.setUserid(userDto.getUserid());
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			user.setRoles(roleSet);
			
		} else {
			Set<String> roleSet= new HashSet<>();
			roleSet.add("ROLE_USER");
			//user.setId(userDto.getId());
			user.setName(userDto.getName());
			//user.setUserid(userDto.getUserid());
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			user.setRoles(roleSet);
		}
		
		User saveUser=userRepository.save(user);
		UserDto responseUserDto= UserDto.builder()
						.id(saveUser.getId())
						.userid(saveUser.getUserid())
						.password(saveUser.getPassword())
						.name(saveUser.getName())
						.roles(saveUser.getRoles())
						.build();
		return responseUserDto;
	}

	@Override
	public UserDto delete(Long id) throws RuntimeException {
		userRepository.deleteById(id);
		UserDto responseUserDto= UserDto.builder().build();
		return responseUserDto;
	}

	@Override
	public void logout() throws RuntimeException {
		
		
	}

	

}