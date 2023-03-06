package com.itwill.user.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.PasswordMissmatchException;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.UserNotFoundException;
/*
 * /user_main 
 * /user_write_form 
 * /user_write_action 
 * /user_login_form
 * /user_login_action 
 * /user_logout_action 
 * /user_view /user_modify_form
 * /user_modify_action 
 * /user_remove_action
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		String forward_path = "user_write_form";
		return forward_path;
	}

	@PostMapping("user_write_action")
	public String user_write_action(@ModelAttribute("fuser") User user, Model model) throws Exception {
		String forward_path = "";
		try {
			int insertCount = userService.create(user);
			forward_path = "redirect:user_login_form";
		} catch (ExistedUserException e) {
			model.addAttribute("msg", e.getMessage());
			//model.addAttribute("fuser", user);
			forward_path = "user_write_form";
		}
		return forward_path;
	}

	@RequestMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}

	@PostMapping("user_login_action")
	public String user_login_action(@ModelAttribute("fuser") User user, Model model, HttpSession session) throws Exception {
		String forwardPath = "";
		try {
			userService.login(user.getUserId(), user.getPassword());
			session.setAttribute("sUserId", user.getUserId());
			forwardPath = "redirect:user_main";
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1", e.getMessage());
			forwardPath = "user_login_form";
		} catch (PasswordMissmatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2", e.getMessage());
			forwardPath = "user_login_form";
		}
		return forwardPath;
	}
	
	@LoginCheck
	@RequestMapping("/user_view")
	public String user_view(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		/************** login check **************
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId == null) {
			forwardPath = "redirect:user_main";
			return forwardPath;
		}
		/*****************************************/
		String sUserId =(String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath = "user_view";
		
		return forwardPath;
		
		
	}

	@LoginCheck
	@PostMapping("user_modify_form")
	public String user_modify_form(HttpServletRequest request) throws Exception {
		String forwardPath = ""; 
		/************** login check **************
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId == null) {
			forwardPath = "redirect:user_main";
			return forwardPath;
		}
		/*****************************************/
		
		String sUserId =(String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser",loginUser);
		forwardPath = "user_modify_form";
		
		return forwardPath;
	}

	@LoginCheck
	@PostMapping("user_modify_action")
	public String user_modify_action(@ModelAttribute User user, HttpServletRequest request) throws Exception {
		String forwardPath = "";
		/************** login check **************
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId == null) {
			forwardPath = "redirect:user_main";
			return forwardPath;
		}
		/*****************************************/
		
		userService.update(user);
		forwardPath = "redirect:user_view";
		return forwardPath;
	}

	@LoginCheck
	@PostMapping("user_remove_action")
	public String user_remove_action(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		/************** login check **************
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId == null) {
			forwardPath = "redirect:user_main";
			return forwardPath;
		}
		/*****************************************/
		String sUserId =(String)request.getSession().getAttribute("sUserId");
		userService.remove(sUserId);
		request.getSession().invalidate(); //=logout이랑 동일한 과정이니 아래처럼도 가능
		//forwardPath = "forward:user_logout_action"; //forward 붙어있으면 controller매핑 찾음. 안 붙이면
		forwardPath = "redirect:user_main";
		return forwardPath;
	}

	@LoginCheck
	@RequestMapping("user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		String forwardPath = "";
		/************** login check **************
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId == null) {
			forwardPath = "redirect:user_main";
			return forwardPath;
		}
		request.getSession().invalidate(); //getSession = true. getSession(false) = 세션 존재하지 않으면 null 반환
		forwardPath = "redirect:user_main";
		/*****************************************/
		
		return forwardPath;
	}

	/*******************GET방식 요청시 user_main redirection*********************/
	@GetMapping({"user_write_action",
				"user_login_action",
				"user_modify_form",
				"user_modify_action",
				"user_remove_action"})
	public String user_get() {
		String forwardPath = "user_main ";
		return forwardPath;
	}
	
	/*******************Local Exception Handler*********************/
	@ExceptionHandler(Exception.class)
	public String user_exception_handeler(Exception e) {
		return "user_error";
	}


}
