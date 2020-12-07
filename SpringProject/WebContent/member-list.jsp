<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 패키지 불러오기 -->
<%@ page import="java.util.*,b201512060.*, model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<%
	ArrayList<MemberDTO> al = 
		(ArrayList<MemberDTO>) request.getAttribute("member-list");
	for(MemberDTO dto : al)	{
%>

	<tr>
		<td><%= dto.getEmail() %></td>
		<td><%= dto.getPw() %></td>
		<td><%= dto.getName() %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>