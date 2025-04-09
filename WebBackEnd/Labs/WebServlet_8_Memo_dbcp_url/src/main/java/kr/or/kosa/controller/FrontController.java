package kr.or.kosa.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글처리
    	request.setCharacterEncoding("UTF-8");
    	
    	// 2. 데이터 받기
    	// url 방식
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlCommand = requestUri.substring(contextPath.length());
    	
    	System.out.println(urlCommand);
    	// 3. 요청 판단하기 (cmd / url)
    	String viewPage = "";
    	
    	MemoDao memoDao = new MemoDao();
    	
    	if (urlCommand.equals("/memo.do")) {
    		viewPage = "/WEB-INF/views/memo/memo_insert.jsp";
    		
    	} else if (urlCommand.equals("/memodetail.do")) {

    		String id = request.getParameter("id");
    		Memo memoDetail = memoDao.getMemoListById(id);
    		
    		request.setAttribute("memodetail", memoDetail);
    		
    		viewPage = "/WEB-INF/views/memo/memo_detail.jsp";
    		
    	} else if (urlCommand.equals("/memolist.do")) {
    		List<Memo> memoList;
    		
			try {
				memoList = memoDao.getMemoList();
				request.setAttribute("memolist", memoList);
	    		viewPage = "/WEB-INF/views/memo/memo_list.jsp";
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

    	} else if (urlCommand.equals("/memoinsert.do")) {
    		// 글쓰기
    		// 입력한 데이터 > DB 연결 > insert > 성공 > 처리
    		String id = request.getParameter("id");
    		String email = request.getParameter("email");
    		String content = request.getParameter("content");
    		
    		Memo memo = new Memo(id, email, content);
    		memoDao.insertMemo(memo);
    		
    		request.setAttribute("memodetail", memo);
    		viewPage = "/WEB-INF/views/memo/memo_detail.jsp";

    	} else if (urlCommand.equals("/memodelete.do")) {
    		// 삭제
    		String id = request.getParameter("id");
    		memoDao.deleteMemo(id);
    		
    		List<Memo> memoList;
			try {
				memoList = memoDao.getMemoList();
				request.setAttribute("memolist", memoList);
	    		viewPage = "/WEB-INF/views/memo/memo_list.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
    		viewPage = "/WEB-INF/views/memo/memo_list.jsp";
    		
    	} else if (urlCommand.equals("/memoupdate.do")) {
    		// 수정
    		String id = request.getParameter("id");
    		Memo memoDetail = memoDao.getMemoListById(id);
 
    		request.setAttribute("memoupdate", memoDetail);
    		viewPage = "/WEB-INF/views/memo/memo_update.jsp";
    		
    	} else if (urlCommand.equals("/memoupdateok.do")) {
    		// 수정
    		String id = request.getParameter("id");
    		String email = request.getParameter("email");
    		String content = request.getParameter("content");
    		
    		Memo memo = new Memo(id, email, content);
    		memoDao.updateMemo(memo);
    	
    		request.setAttribute("memodetail", memo);	
    		viewPage = "/WEB-INF/views/memo/memo_detail.jsp";
    	}
    	
    	
    	// 5. 뷰지정
    	RequestDispatcher dis = request.getRequestDispatcher(viewPage);
    	
    	// 6. 뷰 forward
    	dis.forward(request, response);
    	
    	// 7. 뷰페이지 화면 출력..
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
