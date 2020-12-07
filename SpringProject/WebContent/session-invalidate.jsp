<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 세션에 저장된 속성 sess의  값 : ${sessionScope.sess } <br/>
세션 무효화 <% session.invalidate(); %>
<%-- 현재 세션에 저장된 속성 sess의  값 : ${sessionScope.sess } --%> <br/>
</body>
</html> 