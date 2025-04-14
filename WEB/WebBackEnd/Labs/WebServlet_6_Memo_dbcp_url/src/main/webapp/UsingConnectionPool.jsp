<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
	/* 
		톰켓 : tomcat-dbcp.jar 사용
		기본설정 :  META-INF > context.xml 기본설정 (POOL)
		
        xml 파일에 있는 설정 정보를 가져오기 
	*/
	
	//JNDI(Java Naming and Directory Interface) : 원도우 탐색기 단업 입력 검색 원리 제공 ...
	Context context = new InitialContext();
	//현재 [프로젝트]에서 특정 이름을 가진 객체를 검색 (이름 기반)
	
	//context.xml > name="jdbc/oracle" 
	DataSource ds =  (DataSource)context.lookup("java:comp/env/jdbc/oracle");
	//약속된 표현  java:comp/env/  + 이름 jdbc/oracle
	
	//ds 튜브가게 (설정한 정보에 따라 튜브가 생성... 20개)
	//빌려주세요 .... 반드시 >>>> 반환 >>>>> .....
	
	Connection conn = null;
	
	//빌려주세요
	conn = ds.getConnection(); //튜브하나
	
	out.print("db 연결여부(false)" + conn.isClosed() + "<br>");
	
	//놀아요 (CRUD 작업)
	//반드시 튜브 반환
	
	conn.close(); //자원해제가 아니고 pool  반환 ...
	out.print("db 연결여부(true)" + conn.isClosed() + "<br>");
	
	//그래의  튜브의 사용은 > method 단위 > 반환

%>
</body>
</html>