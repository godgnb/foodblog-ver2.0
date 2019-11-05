package com.blog.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.MemberDao;

public class RegisterIdDupCheckAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("RegisterIdDupCheckAction");
		
		// 파라미터값 가져오기
		String id = request.getParameter("id");
		
		// DAO 객체 준비
		MemberDao memberDao = MemberDao.getInstance();
		
		// 중복 ID 비교 메소드 호출
		boolean isIdDup = memberDao.isIdDupCheck(id);
		
		// JSON 객체 형식으로 응답 보내기
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(isIdDup);
		out.close();
		
		return null;
	}

}
