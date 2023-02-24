package com.itwill.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/user_main")
	public String user_main() {
		return "forward:/WEB-INF/views/user_main.jsp";
	}
}
