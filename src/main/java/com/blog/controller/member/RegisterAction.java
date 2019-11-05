package com.blog.controller.member;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.MemberDao;
import com.blog.vo.MemberVO;

public class RegisterAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberRegisterAction");
		
		// MemberVO 자바빈 객체 생성
		MemberVO memberVO = new MemberVO();
		// 자바빈 객체에 파라미터값 저장
		memberVO.setId(request.getParameter("id"));
		memberVO.setPasswd(request.getParameter("passwd"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setPhone(request.getParameter("phone"));
		memberVO.setEmail(request.getParameter("email"));
		// 가입날짜 생성해서 자바빈에 저장
		memberVO.setRegdate(new Timestamp(System.currentTimeMillis()));
		
		// DAO 객체 준비
		MemberDao memberDao = MemberDao.getInstance();
		
		// 회원가입(추가) 메소드 호출
		memberDao.insertMember(memberVO);
		
		// 로그인 페이지로 이동
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입 되었습니다.');");
		out.println("location.href='loginForm.do';");
		out.println("</script>");
		out.close();

		return null;
	}

}
