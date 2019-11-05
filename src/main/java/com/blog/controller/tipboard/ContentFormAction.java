package com.blog.controller.tipboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.TipBoardAttachDao;
import com.blog.dao.TipBoardDao;
import com.blog.vo.TipBoardAttachVO;
import com.blog.vo.TipBoardCommentVO;
import com.blog.vo.TipBoardVO;

public class ContentFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ContentFormAction");
		
		// 파라미터값 가져오기
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		int num = Integer.parseInt(request.getParameter("num"));

		// ========== 해당 게시글 구하기 작업 ===============
		// DAO 객체 준비
		TipBoardDao tipBoardDao = TipBoardDao.getInstance();
		
		// 조회수 1 증가 메소드 호출
		tipBoardDao.updateReadCount(num);

		// 글번호에 해당하는 레코드 한개 가져오기
		TipBoardVO tipBoardVO = tipBoardDao.getboardTip(num);
		
		// ========== 해당 게시글 첨부이미지 구하기 작업 ===============
		// DAO 객체 준비
		TipBoardAttachDao tipBoardAttachDao = TipBoardAttachDao.getInstance();
		// 글번호에 해당하는 첨부파일정보 가져오기
		TipBoardAttachVO tipBoardAttachVO = tipBoardAttachDao.getAttach(num);
		
		// ========== 해당 게시글 댓글정보 구하기 작업 ===============
		// 한페이지에 보여줄 글 개수
		int pageSize = 5;

		// 시작행번호 구하기
		int startRow = (pageNum - 1) * pageSize + 1;
		
		// 글번호에 해당하는 댓글정보 가져오기
		List<TipBoardCommentVO> commentList = tipBoardDao.getComments(num, startRow, pageSize);
		
		// =========== 페이지 블록 관련정보 구하기 작업 ===============
		// 해당게시글 전체댓글개수 가져오기 메소드
		int count = tipBoardDao.getCommentCount(num);
		
		//전체 글 개수 / 한페이지당 글개수 (+1 : 나머지 있을때)
    	int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
    	
    	// 페이지블록 수 설정
    	int pageBlock = 5;
    	
    	// 시작페이지번호 startPage 구하기
    	int startPage = ((pageNum - 1) / pageBlock) * pageBlock + 1;
    	
    	// 끝페이지번호 endPage 구하기
    	int endPage = startPage + pageBlock - 1;
    	if (endPage > pageCount) {
    		endPage = pageCount;
    	}
		
    	// 페이지블록 관련정보를 Map 또는 VO 객체로 준비
    	Map<String, Integer> pageInfo = new HashMap<String, Integer>();
    	pageInfo.put("count", count);
    	pageInfo.put("pageCount", pageCount);
    	pageInfo.put("pageBlock", pageBlock);
    	pageInfo.put("startPage", startPage);
    	pageInfo.put("endPage", endPage);
		
		// request 영역객체에 저장
    	request.setAttribute("num", num);
    	request.setAttribute("pageNum", pageNum);
		request.setAttribute("tipBoard", tipBoardVO);
		request.setAttribute("attach", tipBoardAttachVO);
		request.setAttribute("commentList", commentList);
		request.setAttribute("pageInfo", pageInfo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("cookingTip/content");
		forward.setRedirect(false);
		return forward;
	}

}
