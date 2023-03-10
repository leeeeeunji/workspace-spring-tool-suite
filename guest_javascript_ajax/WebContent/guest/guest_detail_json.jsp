<%@page import="com.itwill.guest.GuestService"%>
<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int code = 1;
	String url = "";
	String msg = "";
	StringBuffer jsonData = new StringBuffer();
	
	
	String guest_no = request.getParameter("guest_no");
	if (guest_no == null || guest_no.equals("")){
		code = 2;
		url = "";
		msg = "잘못된요청방식입니다.";
	}else{
		System.out.println("*********jQuery Ajax요청정보(guest_detail_json.jsp)*********");
		System.out.println("1.jQuery Ajax요청방식    :" + request.getMethod());
		System.out.println("2.jQuery Ajax요청파라메타:" + guest_no);
		System.out.println("************************************************************");
		GuestService guestService = new GuestService();
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no.trim()));
		code = 1;
		url = "";
		msg = "";
		jsonData.append("{");
		jsonData.append("\"guest_no\":" + guest.getGuest_no() + ",");
		jsonData.append("\"guest_name\":\"" + guest.getGuest_name() + "\",");
		jsonData.append("\"guest_date\":\"" + guest.getGuest_date() + "\",");
		jsonData.append("\"guest_email\":\"" + guest.getGuest_email() + "\",");
		jsonData.append("\"guest_title\":\"" + guest.getGuest_title() + "\",");
		jsonData.append("\"guest_homepage\":\"" + guest.getGuest_homepage() + "\",");
		jsonData.append("\"guest_content\":\"" + guest.getGuest_content() + "\"");
		jsonData.append("}");
	}
%>
{ 
	 "code":<%=code%>,
	 "url":"<%=url%>", 
	 "msg":"<%=msg%>", 
	 "data":[<%=jsonData.toString()%>]
}



