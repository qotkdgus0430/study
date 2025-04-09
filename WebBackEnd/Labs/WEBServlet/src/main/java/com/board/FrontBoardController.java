package com.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
@WebServlet 어노테이션  web.xml > <url-pattern>/simple</url-pattern> 동일한 결과

현재 개발은 어노테이션을 기반으로 한 JAVA 설정 일반
유지보수 : web.xml 파일 설정 변경 .... 이해 필요하다 ...

http://localhost:8090/Board 요청이 오면

FrontBoardController 컴파일되고 실행된다

FrontBoardController.java -> FrontBoardController.class -> 실행 (요청의 의한 특정 함수 실행)
-> GET , POST 요청 -> doGet() 실행 아니면 doPost()

doGet(HttpServletRequest request, HttpServletResponse response)
doPost(HttpServletRequest request, HttpServletResponse response)

두개의 요청 같은 논리라면 ...
*/
@WebServlet(
				description = "게시판 Front  역할을 하는 servlet 입니다",
				urlPatterns = {"/Board"}
				
		   )
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FrontBoardController() {
        super();
       
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
	   //GET , POST 요청 둘다 doProcess가 처리(논리가 동일 하다면)
    	System.out.println("클라이언트 요청 방식 : " + method);
    	
    	//1. 한글처리
    	request.setCharacterEncoding("UTF-8");
    	
    	//2. 데이터 받기
    	//2.1 데이터 받는 방식 2가지 :  command 방식 , url 방식 (ok)
    	//insert.do?cmd=write  > 아하  cmd의 write 글쓰기 판단
    	//list.do?cmd=list     > 아하  cmd의 list 목록을 보여 주어야지  
    	
    	//http://192.168.4.150:8090/Board?cmd=write&id=hong&title=방가&content=방가방가   글쓰기
    	//http://192.168.4.150:8090/Board?cmd=list                                     목록보기
    
    	 String cmd = request.getParameter("cmd");
    	 
    	 String viewPage = null;
    	 //cmd > null > error.jsp
    	 //cmd > boardlist > list.jsp
    	 //cmd > boardwrite > write.jsp 규칙 정의
    	 
   	
    	//3. 비니지스 처리(요구사항) : 암호화 , 관리자 일반자 논리, DB 연결(CRUD)
    	 
    	 if(cmd == null) {
    		 viewPage = "/error/error.jsp";
    	 }else if(cmd.equals("boardlist")) {
    		 /*
    		  Model 
    		  DTO  Board
    		  DAO  BoardDAO > CRUD > 함수 54가지
    		   
    		  BoardDAO board = new BoardDAO();
    		  List<Board> list = board.list(); 
    		  request.setAttribute("list",list);
    		  forward > view > jsp > request.getAttribute("list");
    		  for문 돌려면 화면 출력
    		  */
    		 viewPage = "/board/boardlist.jsp";
    	 }else if(cmd.equals("boardwrite")) {
    		 viewPage = "/board/boardwrite.jsp";
    	 }else if(cmd.equals("boarddelete")) {
    		 //
    	 }else if(cmd.equals("login")) {
    		 viewPage = "/WEB-INF/views/login/login.jsp";
    	 }else {
    		 viewPage = "/error/error.jsp";
    	 }
    	 
    	 
    	//4. 결과 저장(  session (모든 페이지:id값) , request (forward 된 페이지)  , application)
    	
    	//저장 했어요 ^^  request.setAttribute("list",list);
    	 
    	//5. view 지정 ( view 경로 : webapp > WEB-INF > views > Board > list.jsp )
    	
    	RequestDispatcher dis = request.getRequestDispatcher(viewPage); 
    	 
    	//6. view 에게 forward 방식 (request , response) 전달 
    	
    	dis.forward(request, response); // view 에게 request 와 response 전달
    	
    	//기타 ) list.jsp 가 request 또는  session 담기 변수를 가지고 놀며 된다 출력)
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"GET");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"POST");
	}

}
