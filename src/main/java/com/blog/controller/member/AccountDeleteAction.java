package com.blog.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.MemberDao;

public class AccountDeleteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AccountDeleteAction");
		
		// 세션값 가져오기
		HttpSession session = request.getSession();
		String id =(String) session.getAttribute("id");
		String passwd =(String) session.getAttribute("passwd"); // 오류
		
		// DAO 객체 준비
		MemberDao memberDao = MemberDao.getInstance();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 패스워드 일치 메소드 호출
		int check = memberDao.userCheck(id, passwd);
		System.out.println(check);
		if (check != 1) {
			out.println("<script>");
			out.println("alert('패스워드가 일치하지 않습니다');");
			out.println("history.back();");
			out.println("</script>");
			
			return null;
		}
		
		// 회원정보 삭제하기 메소드 호출
		memberDao.deleteMember(id);
		
		// 세션 초기화
		session.invalidate();
		
		out.println("<script>");
		out.println("alert('회원정보를 삭제하였습니다');");
		out.println("location.href='main.do'");
		out.println("</script>");
		
		return null;

	}

}
