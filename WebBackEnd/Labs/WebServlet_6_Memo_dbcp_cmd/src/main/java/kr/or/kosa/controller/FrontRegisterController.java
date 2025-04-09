package kr.or.kosa.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.kosa.dao.RegisterDao;
import kr.or.kosa.dto.RegisterDto;
import oracle.net.aso.r;

import java.io.IOException;


/*
    url ....("*.do")
	command 방식 (parameter 값으로 파악)
	http://192.168.4.158:8090/WebSite/site.do?cmd=list
	http://192.168.4.158:8090/WebSite/site.do?cmd=write
	http://192.168.4.158:8090/WebSite/site.do?cmd=edit
	
	
	Url  방식 (command 방식과 상관없이) 주소 판단
	http://192.168.4.158:8090/WebSite/list.do  > *.do 매핑 > 마지막 주소 > list.do 라면 
	http://192.168.4.158:8090/WebSite/write.do  > *.do 매핑 > 마지막 주소 > write.do 라면 
*/

@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FrontRegisterController() {
        super();
 
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	//1. 한글 처리
    	
    	//2. 데이터 받기
    	
    	//3. 요청 판단하기 (command , url )
    	//3.1 cmd= 가지고 판단
    	
    	//4. 데이터 담기
    	//5. 뷰지정
    	//6. 뷰 forward
    	//7. 뷰페이가 화면 출력 ...그리면 되요
    	
    	request.setCharacterEncoding("UTF-8");
    	
    	String command = request.getParameter("cmd");
    	
    	String viewPage="";
    	
    	//클라이언트 요청한 업무
    	//화면보여주세요 , 업무 처리해 주세요
    	//로그인 화면 > 로그인 처리해주세요
    	//회원가입 화면 > 회원가입 처리해세요
    	
    	if(command.equals("register")) {
    		//회원가입 페이지 (VIEW)
    		//데이터를 담거나 ... (x)
    		viewPage = "/WEB-INF/views/register/register.jsp";
    	}else if(command.equals("registerok")) {
    		//회원가입 처리 (DB작업)
    		//입력한 데이터 > DB 연결 > insert > 성공 > 처리
    		int id = Integer.parseInt(request.getParameter("id"));
    		String pwd = request.getParameter("pwd");
    		String email = request.getParameter("email");
    		
    		RegisterDao registerDao = new RegisterDao();
    		RegisterDto registerDto = new RegisterDto(id, pwd, email);
    		
    		int result =  registerDao.writeOk(registerDto);
    		
    		String resultData="";
    		
    		if(result > 0 ) {
    			resultData = "welcome to kosa " + registerDto.getId() + "님";
    		}else {
    			//예외는 발생하지 않았는데 ... result 0 인경우
    			resultData = "retry ....";
    		}
    		
    		//데이터 담기
    		request.setAttribute("data", resultData);
    		
    		//뷰설정
    		viewPage = "/WEB-INF/views/register/register_welcome.jsp";
    		
    	}
    	
    	//뷰 지정하기
    	RequestDispatcher dis = request.getRequestDispatcher(viewPage);
    	
    	//뷰 forward
    	dis.forward(request, response);
    	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
