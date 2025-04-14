<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		Cookie 종류 2가지
		
		1. 메모리 쿠키 (브라우져): 소멸 시간을 가지고 있지 않아요 (Session 종속)  > getMaxAge() > -1
		
		2. 파일 쿠키 (local PC): 소멸 시간을 가지고 있어요 (2050년 12월 12일)
		   30일
		   (30*24*60*60) 일*시간*분*초 가독성
		   
		   setMaxAge(30*24*60*60) 
	
	 -->
	 	<%
	 		Cookie co = new Cookie("kosa","1004");
	 		co.setMaxAge(30*24*60*60); //30일
	 		response.addCookie(co);
	 	%>
</body>
</html>