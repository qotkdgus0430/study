<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" begin="0" end="10">
		<c:set var="sum" value="${sum+i}" />
		${i}<br>
	</c:forEach>
	sum: 누적 ${sum}<br>
	
	<ul>
		<c:forEach var="i" begin="1" end="9">
			<li>3*${i}=${3*i}</li>
		</c:forEach>
	</ul>
	
	<h3>구구단 출력하기</h3>
	<c:forEach var="i" begin="2" end="9">
		<c:forEach var="j" begin="0" end="9">
			<c:choose>
				<c:when test="${j == 0}">
					${i}단<br>
				</c:when>
				<c:otherwise>
					 ${i} * ${j} = ${i*j}&nbsp;&nbsp;
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<br>
	</c:forEach>
	
	<h3>JSTL forEach</h3>
	<%
		int[] arr = new int[]{10,20,30,40,50};
		for(int i : arr){
			out.print("출력값 :<b><i>" + i + "</i></b><br>");
		}
		
		//선택 ( EL 자바객체 접근 불가)
		request.setAttribute("iarr", arr);
	%>
	<c:forEach var="arr" items="${iarr}">
		배열값 : ${arr}<br>
	</c:forEach>
	
	<hr>
	<h3>아래 방법 권장사항이 아니다 ....</h3>
	<c:set var="array" value="<%=arr %>" />
	<c:forEach var="arr" items="${array}">
		배열값 : ${arr}<br>
	</c:forEach>
</body>
</html>