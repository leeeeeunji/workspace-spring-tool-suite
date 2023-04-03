package com.itwill.user.controller;

import java.nio.charset.Charset;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.itwill.user.exception.UnauthorizedUserException;

@RestControllerAdvice
public class UserRestControllerAdvice {
	
	@ExceptionHandler(UnauthorizedUserException.class)
	public ResponseEntity<Response> method_exception_handler(UnauthorizedUserException e) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		Response response = new Response();
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setMessage(HttpStatus.UNAUTHORIZED.getReasonPhrase());
		response.setData(new HashMap<>());
		
		return new ResponseEntity<>(response, headers, HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> user_exception_handler(Exception e) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		Response message = new Response();
		message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		message.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		message.setData(new HashMap<>());
		return new ResponseEntity<>(message, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
