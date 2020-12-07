<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% 
	//Date형으로 time을 생성한다.
	Date time = new Date(); 
	//SimpleDateFormat은 string형으로 받아오는 값을 Date형으로 형변환 시켜주는 메소드다.
	//dateFormat에 들어오는값을 지정된 형식으로 받아오게될것이다.
	SimpleDateFormat dataFormat= new SimpleDateFormat("yy-mm-ddhh:mm:ss");
%> 
<html>
	<head>
	<title>세션정보</title>
	</head>     
    <body>     
		세션ID:<%= session.getId() %><br>
		세션객체유지시간:<%= session.getMaxInactiveInterval() %><br> 
		<% time.setTime(session.getCreationTime()); %> 
		세션생성시간:<%= dataFormat.format(time) %>
		<% time.setTime(session.getLastAccessedTime()); %>
		최근접근시간:<%= dataFormat.format(time) %>   
		<br><br>
		
		<%
			session.setAttribute("id", "dream"); 
			session.setAttribute("name", "cometrue");
		%>
		
		session.setAttribute("id", "dream");와<br>
		session.setAttribute("name", "cometrue");를실행하여<br>
		 아이디와이름을세션객체에저장하였습니다.<a href="sessionGetAttribute.jsp">세션객체확인하기</a>
		
		
    </body> 
</html> 