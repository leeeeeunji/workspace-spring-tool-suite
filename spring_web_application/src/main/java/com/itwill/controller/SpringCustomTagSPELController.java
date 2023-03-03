package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.Guest;

@Controller
public class SpringCustomTagSPELController {
	@GetMapping("/jstl_fmt_i18n")
	public String jstl_fmt_i18n() {
		return "jstl_fmt_i18n";
		
	}
	@GetMapping("/spring_customtag_spel")
	public String spring_customtag_spel(HttpServletRequest request) {
		
		request.setAttribute("price0", 234234);
		request.setAttribute("name0", "kim eun hi");
		
		request.setAttribute("price1", 12345);
		request.setAttribute("name1", "LEE HYO LEE");
		request.setAttribute("married1", true);
		
		request.setAttribute("price2", 122312213);
		request.setAttribute("name2", "김태희");
		request.setAttribute("married2", false);
		
		
		request.setAttribute("guest", 
				new Guest(1, "김수미", "2022/08/31",
						"guard@gmail.com", "http://www.google.com",
						"오늘은 수요일", "Spring Custom Tag,SPEL에 대해공부합니다."));
		
		return "forward:/WEB-INF/views/spring_customtag_spel.jsp";
	}
	
	
	/************Spring JSP에서 국제화*******************
	1. ApplicationConfig.java에 MessageSource빈설정
	@Bean("messagesSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames("messages/messages", "messages/user");
		return resourceBundleMessageSource;
	}
  	 *****************************************************/
	
	@RequestMapping("/spring_customtag_spel_i18n")
	public String spring_customtag_spel_i18n() {
		return "spring_customtag_spel_i18n";
	}
	
	
	
	
	
	
	
	
	
}
