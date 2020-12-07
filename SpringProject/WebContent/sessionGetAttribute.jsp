<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

session.getAttribute("id")와<br>
 session.getAttribute("name")을실행하여<br>
  세션객체로부터정보를가져왔습니다.<br> 
  아이디: <%= session.getAttribute("id") %> 
  이름: <%= session.getAttribute("name") %>


</body>
</html> 