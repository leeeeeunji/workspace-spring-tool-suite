package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//한 컨트롤러에 있는 여러 개의 메소드를 메소드 별로 매핑 가능 => 멀티매핑 가능
//핸들러매핑은 메소드 별로 매핑을 한다.
@Controller
public class HelloAnnotationMultiRequestMappingController {
	@RequestMapping("hello3")
	public String hello3() {
		
		return "forward:/WEB-INF/views/hello3.jsp";
	}
	
	@RequestMapping("hello4")
	public String hello4() {
		
		return "forward:/WEB-INF/views/hello4.jsp";
	}
	
	@RequestMapping("hello5")
	public String hello5() {
		
		return "forward:/WEB-INF/views/hello5.jsp";
	}
	
	@RequestMapping("/hello_redirect_servlet")
	public String hello_redirect_servlet() {
		
		return "redirect:hello_redirected_servlet";
	}
	
	@RequestMapping("/hello_redirected_servlet")
	public String hello_redirected_servlet() {
		
		return "forward:/WEB-INF/views/hello_redirected_servlet.jsp";
	}
	
	@RequestMapping("/hello_servlet_forward")
	public String hello_servlet_forward() {
		
		return "forward:hello_servlet_forwarded";
	}
	
	@RequestMapping("/hello_servlet_forwarded")
	public String hello_servlet_forwarded() {
		
		return "forward:/WEB-INF/views/hello_servlet_forwarded.jsp";
	}
	
	
	@RequestMapping("/hello_redirect_jsp")
	public String hello_redirect_jsp() {
		return "redirect:hello_redirected.jsp";
	}
	
	
}











