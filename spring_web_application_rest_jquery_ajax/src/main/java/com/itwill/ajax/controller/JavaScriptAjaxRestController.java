package com.itwill.ajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ajax.domain.News;

@RestController 
public class JavaScriptAjaxRestController {
	/*
	 * << @ResponseBody >> 
	 * - ViewResolver-->View-->foward jsp 를 사용하지 않는다 
	 * - MessageConverter(text,xml,json)가 클라이언트로 응답한다. 
	 * - @RestController 어노테이션을 사용하면
	 *   생략가능하다.
	 */
	@GetMapping("/02.ajaxRequest")
	public String ajaxRequest(@RequestParam(name = "id", defaultValue = "") String id) throws Exception {
		String msg = "";
		if(id.startsWith("guard")) {
			msg = "사용가능";
		}else {			
			msg = "사용불가";
		}
		return msg;
	}

	@GetMapping("/03.ajaxRequestGETPOST")
	public String ajaxRequestGETPOST() throws Exception {
		return "";
	}

	@GetMapping("/04.server_clock")
	public String server_clock() {
		return new Date().toLocaleString();
	}

	
	public String newsTitlesHTML() {
		return "";
	}

	
	public Map<String, Object> newsTitlesJSON() {
		
		return null;
	}

	/*
	{
		"count":2,
		"data":["자바","자라","자바라"]
	}
	*/
	public Map<String,Object> suggest(@RequestParam(value = "keyword",defaultValue = "") String keyword ) {
		
		return null;
	}

	public List<News> getNewsList() {
		/*
		 * for(int i=0;i<300000;i++){ System.out.println(""); }
		 */
		List<News> newsList = new ArrayList<News>();
		newsList.add(new News(1, "참으로 수고 많으셨습니다...", "연합뉴스", new Date().toLocaleString()));
		newsList.add(new News(2, "IS 60개국 테러 위협 영상 공개…한국도 포함 포토", "SBS뉴스", new Date().toLocaleString()));
		newsList.add(new News(3, "통일부 남북 당국회담 실무접촉서 입장차", "KBS뉴스", new Date().toLocaleString()));
		newsList.add(new News(4, "내년도 수도권 집값·전세값↑…2∼3년후 조정", "TBC뉴스", new Date().toLocaleString()));
		newsList.add(new News(5, "국토부 폴크스바겐 경유차 연비 3단계로 조사", "OMY뉴스", new Date().toLocaleString()));
		newsList.add(new News(6, "日롯데 신격호 소송 이해하는가 건강문제 제기", "조선뉴스", new Date().toLocaleString()));
		newsList.add(new News(7, "국가유공자 부인 위장 재혼시 유족자격 있다", "YTN뉴스", new Date().toLocaleString()));
		newsList.add(new News(8, "청소년에 한달 100건 성매매 강요 조폭 징역 6년", "CBS뉴스", new Date().toLocaleString()));
		newsList.add(new News(9, "한국인들 실직·이직 공포에 시달린다", "ITWILL뉴스", new Date().toLocaleString()));
		return newsList;
	}

	private String[] keywords = { "AJAX", "AJAX 실전 프로그래밍", "AJA", "AZERA", "자라자", "자라", "자바 프로그래밍", "자바 서버 페이지",
			"자바스터디", "자바서비스", "자바캔" };

	public List<String> search(String keyword) {
		if (keyword == null || keyword.equals(""))
			return new ArrayList<String>();

		keyword = keyword.toUpperCase();

		List<String> result =new ArrayList<String>();

		for (int i = 0; i < keywords.length; i++) {
			if (((String) keywords[i]).startsWith(keyword)) {
				result.add(keywords[i]);
			}
		}
		return result;
	}
}
