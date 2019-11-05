package com.blog.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.MemberDao;

public class LoginAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("loginAction");
		
		// 파라미터값 가져오기
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String rememberMe = request.getParameter("rememberMe");
		
		// DAO 객체 생성
		MemberDao memberDao = MemberDao.getInstance();
		
		// 사용자 확인 메소드 호출
		int check = memberDao.userCheck(id, passwd);
		
		if (check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("passwd", passwd);
		}
		
		// 로그인 상태유지 여부확인 후
		// 쿠키객체 생성해서 응답시 보내기
		if (rememberMe != null && rememberMe.equals("true")) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60*10); // 초단위. 10분 = 60초 * 10 = 600초
			cookie.setPath("/");
			response.addCookie(cookie); // 응답객체에 추가
		}
		
		
		// JSON 객체 형식으로 응답 보내기
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(check);
		out.close();
		
		return null;
	}

}
