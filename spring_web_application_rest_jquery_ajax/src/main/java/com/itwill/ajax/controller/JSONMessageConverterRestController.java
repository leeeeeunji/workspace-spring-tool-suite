package com.itwill.ajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ajax.domain.News;

import io.swagger.annotations.ApiOperation;

@RestController
public class JSONMessageConverterRestController {

	@ApiOperation(value = "뉴스리스트")
	@GetMapping(value = "/news",produces = "application/json;charset=UTF-8")
	public List<News> newsTitlesListJson() {
		return this.getNewsList();
	}
	@GetMapping(value = "/news/{no}" ,produces = "application/json;charset=UTF-8")
	public News newsTitleJSON(@PathVariable int no ) {
		News news=null;
		for(News tempNews:this.getNewsList()) {
			if(tempNews.getNo()==no) {
				news=tempNews;
				break;
			}
		}
		return news;
	}
	/*
	  { 
	   "code": 1,
	   "msg":"성공", 
	   "data": [  { 
	   				"newsTitle": "참으로 수고 많으셨습니다…",
	  				"company": "연합뉴스", "date": "2021. 10. 13 오전 10:48:19" 
	  				},
	   			  .. 
	           ]
	  }
	 */
	
	@GetMapping(value = "/map_news",produces = "application/json;charset=UTF-8")
	public Map<String, Object> newsTitlesMapJson() {
		Map<String,Object> resultMap=new HashMap<String, Object>();
		resultMap.put("code", 1);
		resultMap.put("msg", "성공");
		resultMap.put("data", this.getNewsList());
		return resultMap;
	}

	private List<News> getNewsList() {
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

	
}
