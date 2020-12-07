<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> ${name } </h1>
<h1> ${image } </h1>
<img src="files/${image}"/>
<!-- <input type="button" value="뒤로가기" onclick="history.back(-1);"> -->
<input type="button" value="목록으로가기" onclick="location.href='product-list.do'">
</body>
</html> 