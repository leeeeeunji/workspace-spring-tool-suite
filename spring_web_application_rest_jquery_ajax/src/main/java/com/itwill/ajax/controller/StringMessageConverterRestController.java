package com.itwill.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StringMessageConverterRestController {
	@ResponseBody
	@GetMapping(value = "/response_string1",
				produces = "text/plain;charset=UTF-8")
	public String response_string1() {
		return "hello string for ajax request[한글]";
	}
	@ResponseBody
	@GetMapping(value = "/response_string2",
	produces = "text/html;charset=UTF-8")
	public String response_string2() {
		return "<h3>hello string for ajax request[한글]</h3>";
	}
	
	
	
	
}
