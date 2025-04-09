<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//자바코드 (서버쪽 코드 : backend 구현)
	//JSP UI담당 (MVC > view > 화면에 데이터 출력)
	
	//JSP 혼자 데이터 받고 DB 연결  화면 출력 (페이지하나 간단하게 쓰는 방식)
	//Ex15_ok.jsp?userid=hong&userpwd=1004  >> request 객체에 정보 담겨져 있어요 
	
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("userpwd");
	
	//db JDBC 연결....
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <h3>당신이 입력한 데이터</h3>
	  ID:<%=userid %><br>
	  PWD:<%=pwd %>
</body>
</html>



