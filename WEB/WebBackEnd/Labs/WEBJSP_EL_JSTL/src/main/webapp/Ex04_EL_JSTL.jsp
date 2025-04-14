<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
	String id = request.getParameter("id");
	if(id.equals("hong")){
%>
	<%=id%><img src="images/img_5terre.jpg" style="width: 100px;height: 100px">
<%		
	}
%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL & JSTL 사용</h3>
	<!-- 
			param객체 > request.getParamter()
			request.getParameter("id")  >> ${param.id}
	 -->
	 <c:if test="${param.id == 'hong'}">
	 	${param.id}<img src="images/img_5terre.jpg" style="width: 100px;height: 100px">
	 </c:if>
	 <hr>
	 <c:if test="${param.age > 20}" var="result">
	 	 param.value : ${param.age}<br>
	 </c:if>
	 if 문을 통해서 var를 통해서 result 변수 : ${result}<br>
</body>
</html>