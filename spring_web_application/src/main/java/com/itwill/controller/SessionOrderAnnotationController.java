package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.itwill.dto.Order;

@SessionAttributes("order")
@Controller
public class SessionOrderAnnotationController {
	public SessionOrderAnnotationController() {
		System.out.println("###SessionOrderAnnotationController()생성");
	}
	
	/*
	- @SessionAttributes 파라미터로 지정된 이름과 같은 이름이 
		@ModelAttribute에 지정되어 있을 경우 메소드가 반환되는 값은 세션에 저장된다
	- 아래의 setUpOrder메쏘드 세션에 값을 초기화하는 목적으로 사용되었다
	 */
	@ModelAttribute("order")
	public  Order setUpOrder() {
		System.out.println("=================> setUpOrder");
		return new Order();
	}
	
	
	@RequestMapping(value = "/session_order_process1")
	public String session_order_process1() {
		return "session_order_process1";
	}
	/*
	 @SessionAttributes의 파라미터와 같은 이름이 메서드의 인자로  @ModelAttribute에 있을 경우 
	 세션에 있는 객체를 가져온 후, 클라이언트로 전송받은 파라메타값을 설정한다.
	 */
	@RequestMapping(value = "/session_order_process2")
	public String order_process2(@ModelAttribute("order") Order order) {
		return "session_order_process2";
	}
	@RequestMapping(value = "/session_order_process3")
	public String order_process3(@ModelAttribute("order") Order order) {
		
		return "session_order_process3";
	}
	@RequestMapping(value = "session_order_input_result")
	public String session_order_input_result(@ModelAttribute("order") Order order) {
		return "session_order_input_result";
	}
	/*
	 - SessionStatus 는 컨트롤러 메소드의 파라미터로 사용할 수 있는 스프링 내장 타입이다.
	 - 이 오브젝트의 setComplete() 메서드를 이용하면 현재 컨트롤러의 @SessionAttributes에 의해 저장된 오브젝트를 제거할 수 있다.
	 */
	@RequestMapping(value = "session_order_create")
	public String session_order_create(@SessionAttribute("order") Order order,
										SessionStatus sessionStatus) {
		System.out.println(">>>> 데이타베이스에주문 insert[orderService.create(order)]"+order);
		sessionStatus.setComplete();
		return "session_order_create";
	}
}
