<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- �Ѱܹ��� ���� EL���� ����Ѵ�. param�� �ܼ�, paramValues�� �������� ���� �����´�. -->
<h1>${ param.name }</h1>
<!-- ���ǰ��� ����ǰ�, request���� ���������� �ʾ� �Ѿ�����ʴ´�. -->
<h1>requestScope Ȱ�� : ${requestScope.robj}</h1>
<h1>sessionScope - robj Ȱ�� : ${sessionScope.robj}</h1>
<h1>sessionScope Ȱ�� : ${ sessionScope.sobj }</h1>

</body>
</html>