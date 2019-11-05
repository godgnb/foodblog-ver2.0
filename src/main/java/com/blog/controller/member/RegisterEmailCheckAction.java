package com.blog.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;

public class RegisterEmailCheckAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("RegisterEmailCheckAction");
		
		// 파라미터값 가져오기
		String inputnumber = request.getParameter("inputnumber");
		
		// 세션값 가져오기
		HttpSession session = request.getSession();
		Object checknum = session.getAttribute("checkNum");
		String checkNum =(String) checknum;
		
		boolean result = false;
		
		// 인증번호 입력값 비교
		if (inputnumber.equals(checkNum)) {
			result = true;
		}
		
		// JSON 객체 형식으로 응답 보내기
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
		
		return null;
	}

}
