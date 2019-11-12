package com.blog.controller.tipboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.TipBoardAttachDao;
import com.blog.dao.TipBoardDao;
import com.blog.vo.TipBoardAttachVO;
import com.blog.vo.TipBoardCommentVO;
import com.blog.vo.TipBoardVO;

public class CommentEditFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentEditFormAction");
		
		// 파라미터값 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		int reNum = Integer.parseInt(request.getParameter("reNum"));
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		
		
		// ========== 해당 게시글 첨부이미지 구하기 작업 ===============
		// TipBoardAttachDao 객체 준비
		TipBoardAttachDao tipBoardAttachDao = TipBoardAttachDao.getInstance();
		// 글번호에 해당하는 첨부파일정보 가져오기
		TipBoardAttachVO tipBoardAttachVO = tipBoardAttachDao.getAttach(num);
		
		
		//========= 수정할 글 정보 가져오기 ==============
		// TipBoardDao 객체 준비
		TipBoardDao tipBoardDao = TipBoardDao.getInstance();
		
		// 수정할 글 글번호로 가져오기
		TipBoardVO tipBoardVO = tipBoardDao.getboardTip(num);
		
		//========= 수정할 댓글 정보 가져오기 ==============
		// 수정할 댓글 댓글번호로 가져오기
		TipBoardCommentVO tipBoardCommentVO = tipBoardDao.getComment(reNum);
		
		
		// ========== 해당 게시글 댓글정보 구하기 작업 ===============
		// 한페이지에 보여줄 글 개수
		int pageSize = 5;

		// 시작행번호 구하기
		int startRow = (pageNum - 1) * pageSize;
		
		// 글번호에 해당하는 댓글정보 가져오기
		List<TipBoardCommentVO> commentList = tipBoardDao.getComments(num, startRow, pageSize);
		
		// 뷰(jsp)에서 사용할 데이터를 request 영역개체에 저장
		request.setAttribute("num", num);
		request.setAttribute("reNum", reNum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("tipBoard", tipBoardVO);
		request.setAttribute("attach", tipBoardAttachVO);
		request.setAttribute("commentList", commentList);
		request.setAttribute("tipboardcomment", tipBoardCommentVO);
		
		ActionForward forward = new ActionForward();
		forward.setPath("cookingTip/commentEdit");
		forward.setRedirect(false);
		return forward;
		
	}

}
