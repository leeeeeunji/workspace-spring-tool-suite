<%@ page contentType="application/json; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%!	
	String[] keywords = {"AJAX","AJAX 실전 프로그래밍",
						"AJA","AZERA","자라자",
						"자라","자바 프로그래밍",
			   			"자바 서버 페이지","자바스터디",
			   			"자바서비스","자바캔"};
	public List search(String keyword) {
		if (keyword == null || keyword.equals("")) 
			return java.util.Collections.EMPTY_LIST;
		
		keyword = keyword.toUpperCase();
		
		List result = new java.util.ArrayList();
		
		for ( int i = 0 ; i < keywords.length ; i++ ) {
			if (((String)keywords[i]).startsWith(keyword)) {
				result.add(keywords[i]);
			}
		}
		return result;
	}
%>

<%	request.setCharacterEncoding("utf-8");
	String keyword = request.getParameter("keyword");
	List keywordList = this.search(keyword);
	
	StringBuffer stringBuffer = new StringBuffer();
	stringBuffer.append("{");
	stringBuffer.append("\"count\":" + keywordList.size());
	stringBuffer.append(",");
	stringBuffer.append("\"data\":[");
	for(int i = 0; i < keywordList.size(); i++) {
		stringBuffer.append("\"" + keywordList.get(i) + "\"");
		if(i < keywordList.size()-1) {			
		stringBuffer.append(",");
		}
	}	
	
	stringBuffer.append("]");
	stringBuffer.append("}");
%>
<%=stringBuffer.toString()%>
<%--
{
	count:2,
	data:["자바", "자라", "자바라"]
}
--%>

