package com.itwill.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.security.entity.User;
import com.itwill.security.service.UserService;
import com.security.dto.ResponseDto;
import com.security.dto.UserDto;

import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class UserController {

	private final UserService userService;
	private final UserDetailsService userDetailService;

	@Autowired
	public UserController(UserService userService, UserDetailsService userDetailService) {
		this.userService = userService;
		this.userDetailService = userDetailService;
	}
	
	@PostMapping(value = "/login")
	public User login(@ApiIgnore Authentication authentication) {
		return (User)authentication.getPrincipal();
	}
	
	@GetMapping(value = "/logout_result")
	public User logout_result(@ApiIgnore HttpServletRequest request) {
		return (User)request.getAttribute("logoutuser");
	}

	@PostMapping(value = "/create")
	public ResponseDto create(@ApiParam(value = "아이디", required = true) @RequestParam String userid,
			@ApiParam(value = "비밀번호", required = true) @RequestParam String password,
			@ApiParam(value = "이름", required = true) @RequestParam String name,
			@ApiParam(value = "권한", required = true) @RequestParam String role) {
		UserDto userDto = UserDto.builder().userid(userid).password(password).name(name).role(role).build();

		ResponseDto responseDto = new ResponseDto();
		UserDto responseUserDto = userService.create(userDto);
		if (!responseUserDto.getName().isEmpty()) {
			responseDto.setCode(0);
			responseDto.setMsg("성공");
			responseDto.setData(userDto);
		} else {
			responseDto.setCode(1);
			responseDto.setMsg("실패");
			responseDto.setData(userDto);
		}
		return responseDto;
	}

	@GetMapping(value = "/user")
	public ResponseDto user(@ApiIgnore Authentication authentication) {
		ResponseDto responseDto = new ResponseDto();
		User user = (User) authentication.getPrincipal();
		UserDto userDto = userService.view(user.getId());
		if (!userDto.getName().isEmpty()) {
			responseDto.setCode(0);
			responseDto.setMsg("성공");
			responseDto.setData(userDto);
		} else {
			responseDto.setCode(1);
			responseDto.setMsg("실패");
			responseDto.setData(userDto);
		}
		return responseDto;
	}
	@GetMapping("/logout")
	public  void logout(@ApiIgnore HttpServletRequest request) {
		HttpSession session= request.getSession(false);
		if(session!=null) {
			session.invalidate();
			SecurityContextHolder.clearContext();
			SecurityContext newSecurityContext= SecurityContextHolder.createEmptyContext();
			SecurityContextHolder.setContext(newSecurityContext);
		}
		ResponseDto responseDto = new ResponseDto();
		responseDto.setCode(0);
		responseDto.setMsg("성공");
		responseDto.setData(null);
		
	}
	
	@PutMapping(value = "/user")
	public ResponseDto user(
			@ApiParam(value = "비밀번호", required = true) @RequestParam String password,
			@ApiParam(value = "이름", required = true) @RequestParam String name,
			@ApiParam(value = "권한", required = true) @RequestParam String role) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		
		UserDto userDto = UserDto.builder().
							id(user.getId()).
							userid(user.getUserid()).
							name(name).
							password(password).
							role(role).build();
		
		UserDto responseUserDto = userService.update(userDto);
		
		// 현재 Authentication로 사용자 인증 후 새 Authentication 정보를 SecurityContextHolder에 세팅
		SecurityContextHolder.getContext()
				.setAuthentication(createNewAuthentication(authentication, user.getUsername()));
		ResponseDto responseDto = new ResponseDto();
		if (!responseUserDto.getName().isEmpty()) {
			responseDto.setCode(0);
			responseDto.setMsg("성공");
			responseDto.setData(responseUserDto);
		} else {
			responseDto.setCode(1);
			responseDto.setMsg("실패");
			responseDto.setData(responseUserDto);
		}
		return responseDto;
	}
	
	@DeleteMapping(value = "/user")
	public ResponseDto user(@ApiIgnore HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		// 현재 Authentication로 사용자 인증 후 새 Authentication 정보를 SecurityContextHolder에 세팅
		UserDto responseUserDto = userService.delete(user.getId());
		
		session.invalidate();
		SecurityContextHolder.clearContext();
		SecurityContext newSecurityContext= SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.setContext(newSecurityContext);
		
		
		ResponseDto responseDto=new ResponseDto();
		responseDto.setCode(0);
		responseDto.setMsg("성공");
		responseDto.setData(responseUserDto);
		return responseDto;
	}
	
	protected Authentication createNewAuthentication(Authentication currentAuth, String username) {
		UserDetails newPrincipal = userDetailService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(newPrincipal,
				currentAuth.getCredentials(), newPrincipal.getAuthorities());
		newAuth.setDetails(currentAuth.getDetails());
		return newAuth;
	}

	@GetMapping(value = "/exception")
	public void exceptionTest() throws RuntimeException {
		throw new RuntimeException("접근이 금지되었습니다.");
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Map<String, String>> ExceptionHandler(RuntimeException e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		// responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "400");
		map.put("message", "에러 발생");
		e.printStackTrace();
		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}

	@ResponseBody
	@GetMapping("/auth")
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}