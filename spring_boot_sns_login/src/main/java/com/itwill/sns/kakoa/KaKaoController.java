package com.itwill.sns.kakoa;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KaKaoController {
	@Autowired
	private KaKaoService kakaoService;
	/*
    kakao_main.html 페이지보여주기
    */
	@GetMapping("/kakao_main")
	public String kakao_main() {
		return "kakao_main";
	}
	/*
    - redirection url로 등록된 요청
    - kakao가 발행한 access token 을 code파라메타로 붙혀서 호출해준다.
    - ajax방식으로는 불가능하다.
     */
	@RequestMapping(value = "/kakao_login_action", method = RequestMethod.GET)
	public String kakao_login_action(@RequestParam(value = "code", required = false) String code,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String access_token=kakaoService.getToken(code);
   		 System.out.println("access_token:"+access_token);
   		 KakaoProfile kakaoProfile = kakaoService.getKakaoProfile(access_token);
   		 /*
   		  * 이미 가입한 사용자라면 로그인 진행
   		  * 미가입 사용자라면 회원가입 진행
   		  */
		 
   		/*
		create table kakao_table (
			k_number bigint auto_increment,
			k_name varchar(20) not null,
			k_email varchar(50) not null,
			constraint primary key(k_number)
		);
		 
		-----------------------------------------
		user_id | platform_type | 		email
		-----------------------------------------
		0001    |   kakao1      | test@gmail.com
		0012    |   google      | test@gmail.com
		0023    |   facebook    | test@gmail.com
		5300    |   kakao2      | test01@gmail.com
		*/
   		 HttpSession session=request.getSession();
         session.invalidate();
         // 위 코드는 session객체에 담긴 정보를 초기화 하는 코드.
         session=request.getSession();
         
         //session.setAttribute("kakaoProfile", kakaoProfile);
         request.setAttribute("kakaoProfile", kakaoProfile);
         Cookie authorize_access_token=new Cookie("authorize-access-token", access_token);
         response.addCookie(authorize_access_token);
		return "redirect:kakao_main";
	}
	
	
	@ResponseBody
	@GetMapping("/kakao_userinfo_with_token")
	public KakaoProfile getKakaoUserInfoWithToken( HttpSession session) throws Exception {
		String access_token = "";
		System.out.println(access_token);
		KakaoProfile kakaoProfile = kakaoService.getKakaoProfile(access_token);
		return kakaoProfile;
	}
}