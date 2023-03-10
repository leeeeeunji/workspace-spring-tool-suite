<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int code = 0;
	String url = "";
	String msg = "";
	StringBuffer jsonData = new StringBuffer();
	
	if(request.getMethod().equalsIgnoreCase("GET")){
		code=2;
		url="guest_main";
		msg="잘못된요청방식입니다.";
	}else{
		String guest_noStr =request.getParameter("guest_no");
		GuestService guestService=new GuestService();
		int rowCount=guestService.deleteGuest(Integer.parseInt(guest_noStr));
		code=1;
		url="guest_list_content";
		msg="삭제성공";
	}
%>
{
	"code":<%=code%>,
	"url":"<%=url%>",
	"msg":"<%=msg%>",
	"data":[<%=jsonData.toString()%>]
}
