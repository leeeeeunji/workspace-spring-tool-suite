package com.itwill1.bean.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;
import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;

/*
 @SpringBootApplication
  - 현재 클래스가 위치하는 패키지와 하위 패키지 클래스의 @Annotation을 스캔하여 초기화(객체 생성, 의존성 주입)
 */
@SpringBootApplication
/*
@ComponentScan(basePackages = "com.itwill.guest")
@ComponentScan(value = "com.itwill.guest") //두개 동일, value 생략 가능(@ComponentScan("com.itwill.guest"))
*/
@ComponentScan(basePackages = {"com.itwill.guest", "com.itwill.user"})
public class SpringBootBeanCreateApplicationMain {

	public static void main(String[] args) {
		System.out.println("-------------------Spring Container초기화 시작[ApplicationContext객체 생성 시작]-------------------");
		
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanCreateApplicationMain.class, args);
		
		System.out.println("---------------------Spring Container초기화 끝[ApplicationContext객체 생성 끝]---------------------");
		
		System.out.println("-----------------빈의 아이디로 Spring Container에 등록돼있는 스프링빈 참조 얻기--------------------");
		UserDao userDao1 = (UserDao)applicationContext.getBean("userDao");
		UserService userService1 = (UserService)applicationContext.getBean("userService");
		GuestDao guestDao1 = (GuestDao)applicationContext.getBean("guestDao");
		GuestService guestService1 = (GuestService)applicationContext.getBean("guestService");
		System.out.println(userDao1);
		System.out.println(userService1);
		System.out.println(guestDao1);
		System.out.println(guestService1);

		System.out.println("-----------------빈의 클래스로 Spring Container에 등록돼있는 스프링빈 참조 얻기(위 보다 자주 사용)--------------------");
		UserDao userDao2 = (UserDao)applicationContext.getBean(UserDao.class);
		UserService userService2 = (UserService)applicationContext.getBean(UserService.class);
		GuestDao guestDao2 = (GuestDao)applicationContext.getBean(GuestDao.class);
		GuestService guestService2 = (GuestService)applicationContext.getBean(GuestService.class);
		System.out.println(userDao2);
		System.out.println(userService2);
		System.out.println(guestDao2);
		System.out.println(guestService2);
		
		System.out.println("-------------------빈의 scope[singleton]----------------------");
		System.out.println(applicationContext.getBean(GuestDao.class));
		System.out.println(applicationContext.getBean(GuestDao.class));
		System.out.println(applicationContext.getBean(GuestService.class));
		System.out.println(applicationContext.getBean(GuestService.class));
		
		System.out.println("-------------------빈의 scope[prototype]----------------------");
		System.out.println(applicationContext.getBean(User.class));
		System.out.println(applicationContext.getBean(User.class));
		
		
	}

}
