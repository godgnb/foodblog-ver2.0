package com.blog.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;

public class MainAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MainAction");
		
		ActionForward forward = new ActionForward();
		forward.setPath("main/main");
		forward.setRedirect(false);
		return forward;
	}

}
