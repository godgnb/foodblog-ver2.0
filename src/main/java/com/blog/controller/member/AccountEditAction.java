package com.blog.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.MemberDao;
import com.blog.vo.MemberVO;

public class AccountEditAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AccountEditAction");
		
		// MemberVO 자바빈 객체 생성
		MemberVO memberVO = new MemberVO();
		
		// 자바빈 객체에 파라미터값 저장
		memberVO.setId(request.getParameter("id"));
		memberVO.setPasswd(request.getParameter("passwd"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setPhone(request.getParameter("phone"));
		memberVO.setEmail(request.getParameter("email"));
		
		// DAO 객체 준비
		MemberDao memberDao = MemberDao.getInstance();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 패스워드 일치 메소드 호출
		int check = memberDao.userCheck(memberVO.getId(), memberVO.getPasswd());
		if (check != 1) {
			out.println("<script>");
			out.println("alert('패스워드가 일치하지 않습니다');");
			out.println("history.back();");
			out.println("</script>");
			
			return null;
		}
		
		// 회원정보 수정하기 메소드 호출
		memberDao.updateMember(memberVO);
		
		out.println("<script>");
		out.println("alert('회원정보를 수정하였습니다');");
		out.println("location.href='main.do'");
		out.println("</script>");
		
		return null;
	}

}
