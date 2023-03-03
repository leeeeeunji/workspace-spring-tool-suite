package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.exception.BusinessException1;
import com.itwill.exception.BusinessException2;

@Controller
public class LocalExceptionController {
	@RequestMapping("/business1")
	public String business_method1() throws BusinessException1 {
		boolean b = true;
		if(b) {
			throw new BusinessException1("업무예외발생");
		}
		return "business_result1";
	}
	@RequestMapping("/business2")
	public String business_method2() throws BusinessException2 {
		boolean b = true;
		if(b) {
			throw new BusinessException2("업무예외2발생");
		}
		return "business_result2";
	}
	@RequestMapping("/business3")
	public String business_method3() {
		String name = null;
		int length = name.length();
		return "business_result2";
	}
	
	@ExceptionHandler(BusinessException1.class)
	public String handle_business_exception1(BusinessException1 e, Model model) {
		model.addAttribute("error_msg", e.getMessage());
		return "business_error_result";
	}
	@ExceptionHandler(BusinessException2.class)
	public ModelAndView handle_business_exception2(BusinessException2 e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("business_error_result");
		modelAndView.addObject("error_msg", e.getMessage());
		return modelAndView;
	}
	
	/*
	@ExceptionHandler(NullPointerException.class)
	public String handle_business_exception3(NullPointerException e) {
		return "business_error_result";
	}
	=> 모든 컨트롤러에 적용해야 함 -> GlobalCommonExceptionControllerAdvice 클래스
	*/
	
	
}
