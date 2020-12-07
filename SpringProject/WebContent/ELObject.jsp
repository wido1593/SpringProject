<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%
	//ArrayList에 값들을 추가
	ArrayList<String> al = new ArrayList<String>();
	al.add("인덕");
	al.add("대학교");
	al.add(1,"컴퓨터");//몇번째에 들어갈지 지정함
	al.add("소프트웨어");
	//al의 ArrayList를 arrayList라는 변수에 지정하였다.
	request.setAttribute("arrayList",al);
	//HashMap은 키값을 가지고 있는 배열이라 생각하면된다.
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	map.put("egyou", new Integer(95));
	map.put("shhan", new Integer(97));
	map.put("sjko", new Integer(96));
	request.setAttribute("hashmap", map);

	
	request.setAttribute("robj","request attribute");
    session.setAttribute("sobj", "session attribute");
    session.setAttribute("robj","session - request attribute");
%>

<!-- EL 표현식, 리터널 데이터를 출력해준다. EL문은 scripting elements에서느 사용 못한다.
hashmap으로 맵핑 벨류, 키값을 가져올 수 있다. 아래와 같이 출력을한다면 키값이 나올것이다.
-->
<h1>	${hashmap.egyou} : ${hashmap["shhan"]}</h1><!-- attribute의 키값 -->
<!-- 2번쨰 arrayList 값을 불러온다. 위에서 1번 인덱스에 컴퓨터라는 값이 들어갔다. -->
<h1>${arrayList[1] }</h1><!-- 자리 -->
<!-- EL문으로 값이 널인지 확인하는 방법 : ${empty param["name"]}
	기본적으로 page - request - session - application 순으로 유효접근을 제공한다.
-->
<h1>requestScope 활용 : ${requestScope.robj}</h1>
<!-- 마지막으로 지정된 session을 가져온다. -->
<h1>sessionScope 활용 : ${sessionScope.robj}</h1>
<h1>${ robj }</h1>
<h1>sessionScope 활용 : ${ sessionScope.sobj }</h1>
<h1>${ sobj }</h1>
<a href="next.jsp?name=induk">포워드하지 않음</a>
</body>
</html>