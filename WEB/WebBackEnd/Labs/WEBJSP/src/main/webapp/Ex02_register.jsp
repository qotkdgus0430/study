<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 
		1. 한글처리
		2. 데이터 받기
		3. 로직 수행
		4. 결과 응답하기
	
		
		1. 전송된 데이터 받기
		1.1 Tomcat (내장객체) : request 자동 생성된 객체
		1.2 HttpServletRequest request = new ....  자동생성 (JSP 페이지)
		1.3 클라이언트 서버 요청(회원가입할꺼요 , 게시판을 글 쓸꺼야) > 요청페이지당 한개의 request 객체 자동 생성
		1.4 클라이언트 정보 (입력 데이터 , ip , 브라우져 정보 )
		1.5 request 객체 안에 있는 자원 불러내서 사용하면 된다
		
		GET:  jsp?userid=hong&pwd=1004&hobby=a&hobby=b
		POST: jsp (http 프로토콜 헤더에 숨겨서)
	*/
  	    request.setCharacterEncoding("UTF-8");
		
		String uid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		//hobby 여러개의 데이터 > array
		
		String[] hobby = request.getParameterValues("hobby");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	서버에서 클라이언트 응답<br>
	ID값 <%=uid %>
	PWD값 <%=pwd %>
	<%
		for(String str : hobby){
	%>
	   <b>hobby : </b><%=str%><br>
	<%		
		}
	%>
</body>
</html>