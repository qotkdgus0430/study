<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//EL 은   <%=  대체  (resonse.write)
	
	//EL 과 JSTL 자바가 가지는 자원을 사용불가능 ...
	
	//JSP 출력 .... 자바코드 사용 빈도가 없다
	Date today = new Date();
	
	request.setAttribute("day", today);
	session.setAttribute("day2", today);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 화면 출력 (서버쪽 자원을...)</h3>
	 EL: ${requestScope.day}<br>
	 EL: ${day}<br><!-- day 어떤 객체에 담겨있는 거야 : session , request 판단 어려워요 -->
	 EL: ${day2}<br>
	 EL: ${sessionScope.day2}<br>
</body>
</html>


