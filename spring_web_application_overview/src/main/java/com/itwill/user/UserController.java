package com.itwill.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/user_list")
	public String list(HttpServletRequest request) {
		System.out.println("/list -> UserController.list()");
		List<User> userList = userService.list();
		request.setAttribute("userList", userList);
		return "forward:/WEB-INF/views/user_list.jsp";
	}
}
