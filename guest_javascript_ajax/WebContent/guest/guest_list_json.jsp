<%@page import="com.itwill.guest.Guest"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<%
int code=1;
String msg="msg";
StringBuffer jsonData=new StringBuffer();
String url="guest_main";

String method = request.getMethod();
System.out.println("*********jQuery Ajax요청정보*********");
System.out.println("0.jQuery Ajax요청URL    :" + request.getRequestURI());
System.out.println("1.jQuery Ajax요청방식    :" + method);
System.out.println("2.jQuery Ajax요청파라메타:");
System.out.println("*************************************");

GuestService guestService=new GuestService();
List<Guest> guestList =guestService.selectAll();
for(int i=0;i<guestList.size();i++){
	Guest guest=guestList.get(i);	
	jsonData.append("{");
	jsonData.append("\"guest_no\":"+guest.getGuest_no()+",");
	jsonData.append("\"guest_name\":\""+guest.getGuest_name()+"\",");
	jsonData.append("\"guest_date\":\""+guest.getGuest_date().substring(0,10)+"\",");
	jsonData.append("\"guest_email\":\""+guest.getGuest_email()+"\",");
	jsonData.append("\"guest_homepage\":\""+guest.getGuest_homepage()+"\",");
	jsonData.append("\"guest_title\":\""+guest.getGuest_title()+"\",");
	jsonData.append("\"guest_content\":\""+guest.getGuest_content()+"\"");
	jsonData.append("}");
	if((i+1)!=guestList.size())
		jsonData.append(",");
}

%>
 {
	"code":<%=code%>,
	"url":"<%=url%>",
	"msg":"<%=msg%>",
	"data":[
			<%=jsonData%>
		   ]
}