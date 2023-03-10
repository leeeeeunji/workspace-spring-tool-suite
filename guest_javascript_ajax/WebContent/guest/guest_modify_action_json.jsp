<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="application/json;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
	int code=0;
	String url="";
	String msg="";
	String jsonData="";
	
	if(request.getMethod().equalsIgnoreCase("GET")){
		code=2;
		url="guest_main_content";
		msg="잘못된요청방식입니다.";
		jsonData="";
	}else{
		String guest_noStr=request.getParameter("guest_no");
		String guest_name=request.getParameter("guest_name");
		String guest_email=request.getParameter("guest_email");
		String guest_homepage=request.getParameter("guest_homepage");
		String guest_title=request.getParameter("guest_title");
		String guest_content=request.getParameter("guest_content");
		Guest guest=new Guest(Integer.parseInt(guest_noStr),guest_name,null,
								guest_email,guest_homepage,
								guest_title,guest_content);
		GuestService guestService=new GuestService();
		int rowCount=guestService.updateGuest(guest);
		code=1;
		url="guest_view_content";
		msg="";
		jsonData="{ \"guest_no\":\""+guest.getGuest_no()+"\","+
						   "\"guest_name\":\""+guest.getGuest_name()+"\","+
						   "\"guest_date\":\""+guest.getGuest_date()+"\","+
						   "\"guest_email\":\""+guest.getGuest_email()+"\","+
						   "\"guest_title\":\""+guest.getGuest_title()+"\","+
						   "\"guest_homepage\":\""+guest.getGuest_homepage()+"\","+
						   "\"guest_content\":\""+guest.getGuest_content()+"\"}";
	}
%>
{
	"code":<%=code %>,
	"url":"<%=url%>",
	"msg":"<%=msg%>",
	"data":[<%=jsonData%>]
}