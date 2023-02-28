<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>user_list.jsp</h3><hr/>
<ul>
	<c:forEach items="${userList}" var="user">
		<li>${user.id}, ${user.name}</li>
	</c:forEach>
</ul>
</body>
</html>