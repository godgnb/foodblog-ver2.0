package com.blog.controller.tipboard;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.TipBoardAttachDao;
import com.blog.dao.TipBoardDao;
import com.blog.vo.TipBoardAttachVO;
import com.blog.vo.TipBoardVO;

public class DeleteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteAction");
		
		ActionForward forward = new ActionForward();
		
		// 로그인 안한 사용자면 글목록으로 이동시키기
		HttpSession session = request.getSession();
		String id =(String) session.getAttribute("id");
		
		if (id == null) {
			 forward.setPath("tipboardForm.do");
			 forward.setRedirect(true);
			 return forward;
		}
		
		// 파라미터값 가져오기
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		
		// DAO 객체 준비
		TipBoardDao tipBoardDao = TipBoardDao.getInstance();
		// 삭제할 글 글번호로 가져오기
		TipBoardVO tipBoardVO = tipBoardDao.getboardTip(num);
		
		// 패스워드가 다를때는 "글패스워드 다름" 뒤로가기
		if (!tipBoardDao.isPasswdEqual(num, passwd)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 패스워드가 다릅니다.')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		// 게시글 한개 삭제하기 메소드 호출
		tipBoardDao.deleteBoard(num);
		
		
		// 첨부파일 테이블 tipboardattachDAO 객체 준비
		TipBoardAttachDao tipBoardAttachDao = TipBoardAttachDao.getInstance();
		
		// 게시판 글번호에 해당하는 첨부파일정보 가져오기
		TipBoardAttachVO tipBoardAttachVO = tipBoardAttachDao.getAttach(num);
		
		// application 객체 참조 구하기
		ServletContext appliaction = request.getServletContext();
		
		// 첨부파일정보가 있으면 해당 실제파일 삭제하기
		if (tipBoardAttachVO != null) {
			// 삭제할 첨부파일경로 가져오기
			String realpath = appliaction.getRealPath("/upload");
			
			// 파일 삭제를 위한 File 객체 준비
			File file = new File(realpath, tipBoardAttachVO.getFilename());
			
			if (file.exists()) {
				file.delete();
			}
		}
		
		// 첨부파일 삭제 메소드
		tipBoardAttachDao.deleteAttach(num);
		
		// 삭제처리 후 글목록으로 이동
		forward.setPath("tipboardForm.do?pageNum=" + pageNum);
		forward.setRedirect(true);
		return forward;
	}

}
