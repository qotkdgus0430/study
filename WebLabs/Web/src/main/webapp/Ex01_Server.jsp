<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//자바코드 사용가능
	String str ="Hello World";
	//이 내용은 클라이언트 브라우저가 해석 불가능
	//서버(WAS) 실행되고 해석 (클라이언트 브라우저가 해석 할 수 있는 : text , html , css , javasctipt 변환) 전달

%>
<%= str %>
</body>
</html>