package com.blog.controller.tipboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.TipBoardAttachDao;
import com.blog.dao.TipBoardDao;
import com.blog.vo.TipBoardAttachVO;
import com.blog.vo.TipBoardVO;

public class UpdateFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UpdateFormAction");
		
		ActionForward forward = new ActionForward();
		
		// 로그인 안한 사용자면 글목록으로 이동시키기
		HttpSession session = request.getSession();
		String id =(String) session.getAttribute("id");
		
		if (id == null) {
			 forward.setPath("tipboardForm.do");
			 forward.setRedirect(true);
			 return forward;
		}
		
		// num, pageNum 파라미터값 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// TipBoardDao 객체 준비
		TipBoardDao tipBoardDao = TipBoardDao.getInstance();
		
		// 수정할 글 글번호로 가져오기
		TipBoardVO tipBoardVO = tipBoardDao.getboardTip(num);
		
		
		// TipBoardAttachDao 객체 준비
		TipBoardAttachDao tipBoardAttachDao = TipBoardAttachDao.getInstance();
		
		// 글번호에 해당하는 첨부파일 정보가져오기
		TipBoardAttachVO tipBoardAttachVO = tipBoardAttachDao.getAttach(num);
		
		
		// 뷰(jsp)에서 사용할 데이터를 request 영역개체에 저장
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		request.setAttribute("tipboard", tipBoardVO);
		request.setAttribute("attach", tipBoardAttachVO);
		
		
		forward.setPath("cookingTip/update");
		forward.setRedirect(false);
		return forward;
		
	}

}
