package com.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
		// 1단계 - 요청정보 추출
		String requestURI = request.getRequestURI();
		System.out.println("요청URI주소: " + requestURI);
		
		String ContextPath = request.getContextPath();
		System.out.println("ContextPath: " + ContextPath);
		
		String command = requestURI.substring(ContextPath.length());
		System.out.println("command: " + command);
		
		// 2단계 - 요청정보에 대응하는 코드 실행
		Action action = null;
		ActionForward forward = null;
		ActionFactory factory = ActionFactory.getInstance();
		
		action = factory.getAction(command);
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3단계 - 화면정보를 가진 뷰를 선택해서 실행
		// URL 주소 -> sendRedirect
		// jsp파일명 -> dispatch
		
		if (forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				String path = "WEB-INF/views/" + forward.getPath() + ".jsp" ;
				
				RequestDispatcher dispatcher
				 = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}
		}
		
	} // doGet method


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		// post 요청 한글처리
		request.setCharacterEncoding("utf-8");
		// doGet()메소드 호출
		doGet(request, response);
	} // doPost method

} // FrontController class
