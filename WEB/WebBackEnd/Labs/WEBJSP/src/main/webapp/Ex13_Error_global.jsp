<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/error/commonError.jsp" %> 

<!--  
	예외상황 > 특정 페이지가 처리하도록 설정
	
	1. page errorPage="/error/commonError.jsp   페이지마다 다 작성
	2. 전역적인 방법 (웹 사이트 전체 예외 발생) 강제 페이지 서비스 ( web.xml)
	
	실제 개발시에는 예외를 봐야 ... 
	배포시점에 예외 페이지 처리 .....

-->   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			int data=0/0;
		%>
</body>
</html>