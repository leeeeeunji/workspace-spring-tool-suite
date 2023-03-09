<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.ajax.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public List<News> getNewsList(){
	    /*
		for(int i=0;i<300000;i++){
	    	System.out.println("");
	    }
	    */
		List<News> newsList=new ArrayList<News>();
		newsList.add(new News("참으로 수고 많으셨습니다...","연합뉴스",new Date().toLocaleString()));
		newsList.add(new News("IS 60개국 테러 위협 영상 공개…한국도 포함 포토","SBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("통일부 남북 당국회담 실무접촉서 입장차","KBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("내년도 수도권 집값·전세값↑…2∼3년후 조정","TBC뉴스",new Date().toLocaleString()));
		newsList.add(new News("국토부 폴크스바겐 경유차 연비 3단계로 조사","OMY뉴스",new Date().toLocaleString()));
		newsList.add(new News("日롯데 신격호 소송 이해하는가 건강문제 제기","조선뉴스",new Date().toLocaleString()));
		newsList.add(new News("국가유공자 부인 위장 재혼시 유족자격 있다","YTN뉴스",new Date().toLocaleString()));
		newsList.add(new News("청소년에 한달 100건 성매매 강요 조폭 징역 6년","CBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("한국인들 실직·이직 공포에 시달린다","ITWILL뉴스",new Date().toLocaleString()));
		return newsList;
	}
%>

<%
	List<News> newsList= this.getNewsList();
	/*
		<ul>
				<li>참으로 수고 많으셨습니다...[연합뉴스-2021. 4. 14 오후 12:33:32]</li>
				<li>IS 60개국 테러 위협 영상 공개…한국도 포함 포토[SBS뉴스-2021. 4. 14 오후 12:33:32]</li>
				<li>통일부 남북 당국회담 실무접촉서 입장차[KBS뉴스-2021. 4. 14 오후 12:33:32]</li>
				<li>내년도 수도권 집값·전세값↑…2∼3년후 조정[TBC뉴스-2021. 4. 14 오후 12:33:32]</li>
				<li>국토부 폴크스바겐 경유차 연비 3단계로 조사[OMY뉴스-2021. 4. 14 오후 12:33:32]</li>
				<li>日롯데 신격호 소송 이해하는가 건강문제 제기[조선뉴스-2021. 4. 14 오후 12:33:32]</li>
				<li>국가유공자 부인 위장 재혼시 유족자격 있다[YTN뉴스-2021. 4. 14 오후 12:33:32]</li>
				<li>청소년에 한달 100건 성매매 강요 조폭 징역 6년[CBS뉴스-2021. 4. 14 오후 12:33:32]</li>
				<li>한국인들 실직·이직 공포에 시달린다[ITWILL뉴스-2021. 4. 14 오후 12:33:32]</li>
		</ul>
	*/
	StringBuffer sb=new StringBuffer();
	sb.append("<ul>");
	int count = (int)(Math.random()*newsList.size())+1;
	
	for(int i=0;i<newsList.size();i++){
		News news=newsList.get(i);
		sb.append("<li>"+news.getTitle()+"["+news.getCompany()+"-"+news.getDate()+"][HTML]</li>");
	}
	sb.append("</ul>");
%>
<%=sb.toString()%>









