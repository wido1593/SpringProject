<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
request 객체가 유지된다 : <%= (String) request.getAttribute("egyou") %>
<%
	request.setAttribute("req", "리퀘스트 값 저장");
	session.setAttribute("sess", "세션 값을 저장");
%>
<a href="request-session.jsp"> request, session 객체 전달</a>
</body>
</html>