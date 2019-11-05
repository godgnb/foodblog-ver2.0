package com.blog.controller.tipboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;

public class DeleteFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteFormAction");
		
		// num, pageNum 파라미터값 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// 뷰(jsp)에서 사용할 데이터를 request 영역개체에 저장
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("cookingTip/delete");
		forward.setRedirect(false);
		return forward;
		
	}

}
