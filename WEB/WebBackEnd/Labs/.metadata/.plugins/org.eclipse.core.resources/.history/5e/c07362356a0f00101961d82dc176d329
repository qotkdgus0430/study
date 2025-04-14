<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	1. 한글처리
	2. 데이터 받기
	3. 로직처리(비지니스) >> DB 작업 (CRUD) >> 결과화면 >> client  전달
	
	내장객체 (WAS : 톰켓) 
	1. request   ( 클라이언트 정보를 담고 있는 객체 : 요청페이지당 한개 (서버에서))
	2. response  ( 응답객체(write) )
	3. session   ( 클라이언트 마다 고유하게 생성되는 고유객체  : 접속자 100명 서버는 100객체 생성 )
	4. application (전역자원 : 접속하는 모든 사용자가 공유하는 객체)
	5. out (출력객체 : out.print() )
	*/
	
	request.setCharacterEncoding("UTF-8");
	
	String id= request.getParameter("id");
	
	/*
	    JDBC (MVC)
		MemberDao memberdao = new MemberDao();
		MemberDto memberdto = new MemberDto();
		memberdto.setId(id)
		
		int result memeberdao.insertData(memberdto);
		결과 화면 출력 ...(JSP)
		
		request 객체 다양한 정보 
	*/
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  1.입력값 : <%=id %><br>
	  2.접속한 클라이언트 IP  : <%= request.getRemoteAddr() %>
	  3.포트 : <%= request.getServerPort() %>
	  4.경로 : <%= request.getContextPath() %>
	  <!--
	  getContextPath : 사이트명 , 가상디렉토리명 , 홈 디렉토리 , default 웹 경로
	    -->
</body>
</html>