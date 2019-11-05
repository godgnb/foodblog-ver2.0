package com.blog.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.MemberDao;
import com.blog.vo.MemberVO;

public class AllMemberAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AllMemberFormAction");
		
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
		
		// ===========================================
		// 한 페이지에 해당하는 회원정보목록 구하기 작업
		
		// DAO객체 준비
		MemberDao memberDao = MemberDao.getInstance();
		
		// 한페이지에 보여줄 회원정보 개수
		int pageSize = 10;
	
		// 시작행번호 구하기
		int startRow = (pageNum - 1) * pageSize + 1;
		
		// 전체회원정보 가져오기 메소드 호출
		List<MemberVO> memberList = memberDao.getMembers(startRow, pageSize, search);
		
		
		// ===========================================
		// 페이지 블록 관련정보 구하기 작업
		
		// 전체회원 수 가져오기 메소드 호출
		int count = memberDao.memberCount(search);
		
		//전체 회원수 / 한페이지당 회원정보개수 (+1 : 나머지 있을때)
    	int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
    	
    	// 페이지블록 수 설정
    	int pageBlock = 10;
    	
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
		request.setAttribute("memberList", memberList);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("search", search);
		
		ActionForward forward = new ActionForward();
		forward.setPath("member/allMember");
		forward.setRedirect(false);
		return forward;
	}

}
