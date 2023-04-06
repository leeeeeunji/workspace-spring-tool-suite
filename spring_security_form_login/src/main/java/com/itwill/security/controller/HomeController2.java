package com.itwill.security.controller;

import org.springframework.security.core.Authentication;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController2 {
	@GetMapping("/")
	public String main(Authentication authentication, Principal principal) {
		System.out.println(authentication);
		System.out.println(principal);
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@GetMapping("/login-error")
	public String loginError() {
		return "loginForm";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "AccessDenied";
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/user-page")
	public String userPage() {
		return "UserPage";
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin-page")
	public String adminPage() {
		return "AdminPage";
	}
	
	@ResponseBody
	@GetMapping("/auth")
	public Authentication authentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
}
