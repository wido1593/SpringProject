<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 넘겨받은 값을 EL문을 출력한다. param은 단수, paramValues는 여러개의 값을 가져온다. -->
<h1>${ param.name }</h1>
<!-- 세션값을 저장되고, request값을 포워딩하지 않아 넘어오지않는다. -->
<h1>requestScope 활용 : ${requestScope.robj}</h1>
<h1>sessionScope - robj 활용 : ${sessionScope.robj}</h1>
<h1>sessionScope 활용 : ${ sessionScope.sobj }</h1>

</body>
</html>