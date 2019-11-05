package com.blog.controller.tipboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;

public class WriteFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteFormAction");
		
		ActionForward forward = new ActionForward();
		forward.setPath("cookingTip/write");
		forward.setRedirect(false);
		return forward;
	}

}
