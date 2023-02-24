package com.itwill.annotation.exe;
@Component
@ComponentSingleValue(id = 100)
@ComponentMultiValue(count=10, names= {"KIM", "SIM", "JIM"}, print=true)
public class ComponentUsingClass {
	
	@AutoWired
	private Object member;
	
	@AutoWired
	public ComponentUsingClass(Object member) {
		
	}
	
	@AutoWired
	public void method1(Object member) {
		
	}
	
	public void method2(@AutoWired Object member) {
		
	}
}
