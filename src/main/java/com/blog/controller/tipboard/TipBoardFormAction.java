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
import com.blog.vo.TipBoardVO;

public class TipBoardFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("TipBoardFormAction");
		
		//파라미터값 search, pageNum 가져오기
		String search = request.getParameter("search");
		if (search == null) {
			search ="";
		}
		String strPageNum = request.getParameter("pageNum");
		if (strPageNum == null) {
			strPageNum = "1";
		}
		
		// 페이지 번호
		int pageNum = Integer.parseInt(strPageNum);

		// =========== 한 페이지에 해당하는 글목록 구하기 작업 ===============
		// DAO 객체 준비
		TipBoardDao tipBoardDao = TipBoardDao.getInstance();

		// 한페이지에 보여줄 글 개수
		int pageSize = 10;

		// 시작행번호 구하기
		int startRow = (pageNum - 1) * pageSize;

		// 글목록 가져오기 메소드 호출
		List<TipBoardVO> tipboardList = tipBoardDao.getBoards(startRow, pageSize, search);
				
			
		// =========== 페이지 블록 관련정보 구하기 작업 ===============
		// tipboard테이블 전체글개수 가져오기 메소드
		int count = tipBoardDao.getBoardCount(search);
		
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
    
    	// 뷰(jsp)에 사용할 데이터를 request 영역개체에 저장
    	request.setAttribute("tipboardList", tipboardList);
    	request.setAttribute("pageInfo", pageInfo);
    	request.setAttribute("pageNum", pageNum);
    	request.setAttribute("search", search);
    	
    	
    	ActionForward forward = new ActionForward();
    	forward.setPath("cookingTip/tipBoard");
    	forward.setRedirect(false);
		return forward;
	}

}
