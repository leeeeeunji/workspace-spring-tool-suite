package com.itwill.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UnauthorizedUserException;
import com.itwill.user.exception.UserNotFoundException;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
/*
POST 	/user/login 		- login  user 
GET   	/user/logout		- logout user 
POST 	/user 			- create user 
PUT 		/user/{id} 		- modify user by {id}
GET 		/user/{id} 		- GETs the details of the user with {id}
DELETE 	/user/{id} 		- Delete the user with id 
*/
@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	@ApiOperation("회원가입")
	@PostMapping(value = "/user", produces = "application/json;charset=UTF-8")
	public Response user_write_action(@RequestBody User user) throws Exception {
		Response response = new Response();
		userService.create(user);
		response.setStatus(ResponseStatusCode.CREATED_USER);
		response.setMessage(ResponseMessage.CREATED_USER);
		response.setData(user);
		return response;
	}
	@ApiOperation("회원로그인")
	@PostMapping(value ="/user/login", produces = "application/json;charset=UTF-8")
	public Response user_login_action(@RequestBody User user,@ApiIgnore HttpSession session) throws Exception {
		Response response = new Response();
		userService.login(user.getUserId(), user.getPassword());
		session.setAttribute("sUserId", user.getUserId());
		response.setStatus(ResponseStatusCode.LOGIN_SUCCESS);
		response.setMessage(ResponseMessage.LOGIN_SUCCESS);
		response.setData(user);
		return response;
	}

	@LoginCheck
	@GetMapping(value="/user/{userId}", produces = "application/json;charset=UTF-8")
	public Response user_view(@PathVariable String userId, @ApiIgnore HttpSession session) throws Exception {
		Response response = new Response();
		String sUserId = (String) session.getAttribute("sUserId");
		if (!sUserId.equals(userId)) {
			throw new UnauthorizedUserException("");
		}
		User loginUser = userService.findUser(sUserId);
		response.setStatus(ResponseStatusCode.READ_USER);
		response.setMessage(ResponseMessage.READ_USER);
		response.setData(loginUser);

		return response;
	}

	@LoginCheck
	@PutMapping(value="user/{userId}", produces = "application/json;charset=UTF-8")
	public Response user_modify_action(@PathVariable String userId, @RequestBody User user,
			@ApiIgnore HttpSession session) throws Exception {
		Response response = new Response();
		String sUserId = (String) session.getAttribute("sUserId");
		if (!sUserId.equals(userId)) {
			throw new UnauthorizedUserException("");
		}
		user.setUserId(userId);
		userService.update(user);
		response.setStatus(ResponseStatusCode.UPDATE_USER);
		response.setMessage(ResponseMessage.UPDATE_USER);
		response.setData(user);
		return response;
	}

	@LoginCheck
	@DeleteMapping(value="user/{userId}", produces = "application/json;charset=UTF-8")
	public Response user_remove_action(@PathVariable String userId,  @ApiIgnore  HttpSession session) throws Exception {
		Response response = new Response();
		String sUserId = (String) session.getAttribute("sUserId");
		if (!sUserId.equals(userId))
			throw new UnauthorizedUserException("");

		userService.remove(sUserId);
		session.invalidate();

		response.setStatus(ResponseStatusCode.DELETE_USER);
		response.setMessage(ResponseMessage.DELETE_USER);
		response.setData(new HashMap<>());
		return response;
	}

	@LoginCheck
	@GetMapping(value="user/logout", produces = "application/json;charset=UTF-8")
	public Response user_logout_action( @ApiIgnore  HttpSession session) throws  Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId==null)
			throw new UnauthorizedUserException("");
		
		Response response = new Response();
		session.invalidate();
		response.setStatus(ResponseStatusCode.LOGOUT_USER);
		response.setMessage(ResponseMessage.LOGOUT_USER);
		response.setData(new HashMap<>());
		return response;
	}

	//@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	//@GetMapping(value={ "/user" },produces = "application/json;charset=UTF-8")
	public Response user_get() throws Exception {
		Response response = new Response();
		response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
		response.setMessage(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
		response.setData(new HashMap<>());
		return response;
	}
		
	
	@ExceptionHandler(value = {UserNotFoundException.class})
	public Response user_not_found_exception_handler(UserNotFoundException e) throws Exception {
		Response response = new Response();
		response.setStatus(ResponseStatusCode.LOGIN_FAIL_NOT_FOUND_USER);
		response.setMessage(e.getMessage());
		response.setData(e.getData());
		return response;
	}
	@ExceptionHandler(value = {ExistedUserException.class})
	public Response user_existed_exception_handler(ExistedUserException e) throws Exception {
		Response response = new Response();
		response.setStatus(ResponseStatusCode.CREATE_FAIL_EXISTED_USER);
		response.setMessage(e.getMessage());
		response.setData(e.getData());
		return response;
	}
	@ExceptionHandler(value = {PasswordMismatchException.class})
	public Response user_password_misnatch_handler(PasswordMismatchException e) throws Exception {
		Response response = new Response();
		response.setStatus(ResponseStatusCode.LOGIN_FAIL_PASSWORD_MISMATCH_USER);
		response.setMessage(e.getMessage());
		response.setData(e.getData());
		return response;
	}

}
