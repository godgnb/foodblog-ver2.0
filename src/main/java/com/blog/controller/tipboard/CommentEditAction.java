package com.blog.controller.tipboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.TipBoardDao;
import com.blog.vo.TipBoardCommentVO;

public class CommentEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentEditAction");
		
		int num= Integer.parseInt(request.getParameter("num"));
		int reNum = Integer.parseInt(request.getParameter("reNum"));
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		
		//========= 댓글 수정 작업 ==============
		// 자바빈 TipBoardCommentVO 객체 생성
		TipBoardCommentVO tipBoardCommentVO = new TipBoardCommentVO();
		
		// 파라미터 찾아서 자바빈에 저장
		tipBoardCommentVO.setNum(num);
		tipBoardCommentVO.setReNum(reNum);
		tipBoardCommentVO.setId(request.getParameter("id"));
		tipBoardCommentVO.setContent(request.getParameter("content"));
		
		// TipBoardDao객체 준비
		TipBoardDao tipBoardDao = TipBoardDao.getInstance();
		
		// 댓글 한개 수정하는 메소드 호출
		tipBoardDao.editComment(tipBoardCommentVO);
		
		
		//========= 해당 게시글 댓글정보 구하기 작업 ==============
		// 한페이지에 보여줄 글 개수
		int pageSize = 5;

		// 시작행번호 구하기
		int startRow = (pageNum - 1) * pageSize;
		
		
		// 글번호에 해당하는 댓글정보 가져오기
		List<TipBoardCommentVO> commentList = tipBoardDao.getComments(num, startRow, pageSize);
		
		
		// request 영역객체에 저장
		request.setAttribute("commentList", commentList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("contentForm.do?num=" + num + "&pageNum=" + pageNum);
		forward.setRedirect(true);
		return forward;
	}

}
