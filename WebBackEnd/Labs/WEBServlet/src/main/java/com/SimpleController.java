package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/*
  1. servlet 정의 : java 파일인데 웹에 사용할 수 있는 자바 파일 (request, response 객체활용)
  1.1 java 파일에 extends HttpServlet 상속관계 (일반자바 웹 객체(request, response) 사용가능)
  1.2 웹용 사용할수 있는 java 파일 : servlet 
  
  Tip) 자바 웹 개발언어가 아니고 ... 웹 ..... java .... request, response ... 상속 ... servlet 웹서비스
       servlet 자바코드 편하고 UI 만드는 작업 힘들어요 >> 그래서 탄생 >> jsp 
       
       servlet 형 -> jsp 동생 (UI 구성 편하고 + JAVA 코드 제어 힘들어 졌어요)
        

      HttpServletRequest request,   자동으로 request 생성되고 그 주소를 할당   //HttpServletRequest 인터페이스
      HttpServletResponse response  자동으로 response  생성되고 그 주소를 할당


	 1. 요청
	 JSP
	 http://192.168.4.150:8090/default.jsp
	 
	 servlet
	 http://192.168.4.150:8090/SimpleController.java (x) 요청
	 
	 web.xml 
	 또는
	 @WebServlet 
	 어떤 요청 주소가 들어어면 SimpleController.java 컴파일하고 실행 ... 정의
	 http://192.168.4.150:8090/Simple
	 
	 web.xml 
	 어떤 요청이 오면 어떤 servlet 파일 컴파일 하고 실행 결정 ....url_pattern 정의
	 <servlet>
  		<servlet-name>simplecontroller</servlet-name>
  		<servlet-class>com.SimpleContoller</servlet-class>
    </servlet>
    <servlet-mapping>
  		<servlet-name>simplecontroller</servlet-name>
  		<url-pattern>/simple</url-pattern>
    </servlet-mapping>
    
    컴파일 하고 실행할 거야 ...
    
    주소 창에 : http://localhost:8090/simple 엔터
    web.xml 설정된 servlet-mapping  근거로 SimpleContoller.java 컴파일 하고 실행
    
    protected void doGet() 함수 아니면
    protected void doPost() 둘중에 하나가 자동 실행
    
    동기식 .... 둘중에 하나의 방식으로 요청 보내요 
    GET   >>  void doGet() 실행 (자동)
    POST  >>  void doPost() 실행(자동)
*/

//@WebServlet("/Simple")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SimpleController() {
        super();
        System.out.println("SimpleController 생성자 함수 실행 : 초기화");
       
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청이 : GET 자동실행 함수");
		
		//JSP 사용했던 방법
		
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		
		//2. 데이터 받기
		String type = request.getParameter("type");
		
		//3. 비지니스로직(요구사항)
		Object resultObj = null;
		if(type == null || type.equals("greeting")) {
			resultObj = "hello world";
		}else if(type.equals("date")) {
			resultObj = new Date();
		}else {
			resultObj = "invalid String type";
		}
		
		//3.1 데이터 담기
		//저장한 결과를 UI (JSP 페이지) 전달
		//request >> xx번지
		request.setAttribute("result", resultObj); //request (include , forward 된 페이지...)
		
		
		//현재 webapp 폴더안에 > simpleview.jsp 
		//사실 실무 > webapp > WEB-INF > views > board > board.jsp
		
		
		//4. 페이지 이동 (UI 구성)
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		//getRequestDispatcher( view 지정 )
		
		dis.forward(request,response); //현재 내가 가지는 request 객체를 주소값을  forward  전달 
		//request 객체 xx번지 
		//forward 된 페이지 /simpleview.jsp
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청이 : POST 자동실행 함수");
		
	}

}
