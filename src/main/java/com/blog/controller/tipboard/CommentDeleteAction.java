package com.blog.controller.tipboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.TipBoardDao;
import com.blog.vo.TipBoardCommentVO;

public class CommentDeleteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentDeleteAction");
		
		int num = Integer.parseInt(request.getParameter("num"));
		int renum = Integer.parseInt(request.getParameter("reNum"));
		String pageNum = request.getParameter("pageNum");
		
		
		//========= 댓글 삭제 ==============
		// TipBoardDao객체 준비
		TipBoardDao tipBoardDao = TipBoardDao.getInstance();
		
		// 댓글 한개 삭제하는 메소드 호출
		tipBoardDao.deleteComment(renum);
		
		//========= 댓글 카운트 내리는 작업 ==============
		tipBoardDao.commCountDown(num);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("contentForm.do?num=" + num + "&pageNum=" + pageNum);
		forward.setRedirect(true);
		return forward;
	}

}
