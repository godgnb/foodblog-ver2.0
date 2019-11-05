package com.blog.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.MemberDao;
import com.blog.vo.MemberVO;

public class AccountFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AccountFormAction");
		
		// 세션값 가져오기
		HttpSession session = request.getSession();
		String id =(String) session.getAttribute("id");

		// DAO 객체 준비
		MemberDao memberDao = MemberDao.getInstance();

		// 회원정보 가져오는 메소드 호출
		MemberVO memberVO = memberDao.getMember(id);
		
		// request 영역객체에 저장
		request.setAttribute("member", memberVO);
		
		ActionForward forward = new ActionForward();
		forward.setPath("member/myAccount");
		forward.setRedirect(false);
		return forward;
	}

}
