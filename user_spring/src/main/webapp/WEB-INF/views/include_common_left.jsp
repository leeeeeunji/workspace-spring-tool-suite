<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>   
<p>
	<strong><s:message code="menu.title"/></strong>
</p>
<ul>
	<c:if test="${sUserId!=null}">
		<li><a href=''><s:message code="menu.id" arguments="${sUserId}"/></a></li>
		<li><a href='user_view'><s:message code="menu.myinfo"/></a></li>
		<li><a href="user_logout_action"><s:message code="menu.logout"/></a></li>
	</c:if>	
	<c:if test="${empty sUserId }">
		<li><a href="user_login_form"><s:message code="menu.login"/></a></li>
		<li><a href="user_write_form"><s:message code="menu.join"/></a></li>
	</c:if>
</ul>
