<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	/*
	EL&JSTL WAS 해석 (서버쪽 스크립트)
	<c:set 변수생성 , 값을 저장
	<c:if test="조건"
	<c:choose  여러가지 조건을 판단 (if 보다 활용도가 높아요)
	<c:forEach   개선된 for문 > javaScript foreach 같은 논리
	<c:forTokens  자바 for문하고 split 결합
	<c:out        JSTL EL같은 역할 출력
	<c:catch      예외처리 기능
	*/
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>JSTL & EL</h3>
		EL parameter : ${param.id} - ${param.pwd}<br>
		
		<h3>param 변수 저장</h3>
		<c:set var="userid" value="${param.id}" />
		<c:set var="userpwd" value="${param.pwd}" />
		
		<h3>변수값 출력</h3>
		id: ${userid}<br>
		pwd:${userpwd}<br>
		<hr>
		<c:if test="${!empty userpwd}"><!-- 비밀번호가 존재하면  -->
			<h3>not empty password</h3>
			<c:if test="${userpwd == '1004'}">
				<h3>welcome admin ^^</h3>
			</c:if>
		</c:if>
		
</body>
</html>