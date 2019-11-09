package com.blog.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.SimpleEmail;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;

public class RegisterEmailCheckFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("RegisterEmailCheckFormAction");
		
		String inputEmail = request.getParameter("inputEmail");
		
		// ================ 인증번호 만들기 ======================
		String checkNum = RandomNum();
		
		// ================ 이메일 보내기 작업 ====================
		// SimpleEmail 객체 생성
		SimpleEmail email = new SimpleEmail();
		
		// SMTP 서버 연결 설정
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication("godgnb123", "wynmfzqmkjrgohhb");
		
		// SMTP SSL, TLS 설정
		email.setStartTLSEnabled(true);
		email.setSSLOnConnect(true);
		
		String result = "";
		
		try {
			// 보내는 사람 설정
			email.setFrom("godgnb123@google.com", "관리자", "utf-8");
			// 받는 사람 설정
			email.addTo(inputEmail,"인증번호", "utf-8");
			// 제목 설정
			email.setSubject("회원가입 이메일인증번호입니다.");
			// 본문 설정
			email.setMsg(checkNum);
			
			// 메일 전송
			result = email.send();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result: " + result);
		
		// 세션값에 저장
		HttpSession session = request.getSession();
		session.setAttribute("checkNum", checkNum);
		
		ActionForward forward = new ActionForward();
		forward.setPath("member/registerEmailCheck");
		forward.setRedirect(false);
		return forward;
	}
	
	// 인증번호 6자리 난수 설정
	public String RandomNum() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i <= 5; i++) {
			int n = (int) (Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}
}

