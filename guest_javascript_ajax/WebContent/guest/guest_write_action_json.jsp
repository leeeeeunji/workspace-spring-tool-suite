<%@page import="com.itwill.guest.GuestService"%>
<%@page import="com.itwill.guest.Guest"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	int code = 0;
	String url = "";
	String msg = "";
	StringBuffer jsonData = new StringBuffer();
	if(request.getMethod().equalsIgnoreCase("GET")){
		code=2;
		url="guest_main_content";
		msg="잘못된요청방식입니다.";
	}else{
		try{
			Guest guest=new Guest(0,
								  request.getParameter("guest_name"),
								  null,
								  request.getParameter("guest_email"),
								  request.getParameter("guest_homepage"),
								  request.getParameter("guest_title"),
								  request.getParameter("guest_content")
								  );
			GuestService guestService=new GuestService();
			int rowCount=guestService.insertGuest(guest);
			code=1;
			url="guest_list_content";
			msg="쓰기성공";
		}catch(Exception e){
			e.printStackTrace();
			code=2;
			url="guest_main_content";
			msg="쓰기실패";
		}
	}
%>
{
	"code":<%=code%>,
	"url":"<%=url%>",
	"msg":"<%=msg%>",
	"data":[<%=jsonData.toString()%>]
}
