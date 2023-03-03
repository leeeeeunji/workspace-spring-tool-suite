<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	alert('${GUEST_NOT_FOUND_MSG}');
	location.href = 'guest_list.do';
</script>
