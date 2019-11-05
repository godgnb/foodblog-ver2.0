package com.blog.controller;

import java.util.HashMap;
import java.util.Map;

import com.blog.controller.member.AccountDeleteAction;
import com.blog.controller.member.AccountEditAction;
import com.blog.controller.member.AccountFormAction;
import com.blog.controller.member.AdminFormAction;
import com.blog.controller.member.AllMemberAction;
import com.blog.controller.member.LoginAction;
import com.blog.controller.member.LoginFormAction;
import com.blog.controller.member.LogoutAction;
import com.blog.controller.member.MainAction;
import com.blog.controller.member.RegisterAction;
import com.blog.controller.member.RegisterEmailCheckAction;
import com.blog.controller.member.RegisterEmailCheckFormAction;
import com.blog.controller.member.RegisterFormAction;
import com.blog.controller.member.RegisterIdDupCheckAction;
import com.blog.controller.tipboard.CommentDeleteAction;
import com.blog.controller.tipboard.CommentEditAction;
import com.blog.controller.tipboard.CommentEditFormAction;
import com.blog.controller.tipboard.CommentWriteAction;
import com.blog.controller.tipboard.ContentFormAction;
import com.blog.controller.tipboard.DeleteAction;
import com.blog.controller.tipboard.DeleteFormAction;
import com.blog.controller.tipboard.TipBoardFormAction;
import com.blog.controller.tipboard.UpdateAction;
import com.blog.controller.tipboard.UpdateFormAction;
import com.blog.controller.tipboard.WriteAction;
import com.blog.controller.tipboard.WriteFormAction;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}

	private Map<String, Action> map = new HashMap<String, Action>();

	private ActionFactory() {
		// main 명령어 Action객체 등록
		map.put("/main.do", new MainAction());
		
		/// member 명령어 관련 Action객체 등록
		map.put("/loginForm.do", new LoginFormAction());
		map.put("/login.do", new LoginAction());
		map.put("/registerForm.do", new RegisterFormAction());
		map.put("/register.do", new RegisterAction());
		map.put("/registerIdDupCheck.do", new RegisterIdDupCheckAction());
		map.put("/logout.do", new LogoutAction());
		map.put("/myAccountForm.do", new AccountFormAction());
		map.put("/edit.do", new AccountEditAction());
		map.put("/accountDelete.do", new AccountDeleteAction());
		map.put("/registerEmailCheckForm.do", new RegisterEmailCheckFormAction());
		map.put("/registerEmailCheck.do", new RegisterEmailCheckAction());
		
		// 관리자 명령어 관련 Action객체 등록
		map.put("/adminForm.do", new AdminFormAction());
		map.put("/allMember.do", new AllMemberAction());
		
		
		
		// tipboard 명령어 관련 Action객체 등록
		map.put("/tipboardForm.do", new TipBoardFormAction());
		map.put("/writeForm.do", new WriteFormAction());
		map.put("/write.do", new WriteAction());
		map.put("/contentForm.do", new ContentFormAction());
		map.put("/deleteForm.do", new DeleteFormAction());
		map.put("/delete.do", new DeleteAction());
		map.put("/updateForm.do", new UpdateFormAction());
		map.put("/update.do", new UpdateAction());
		map.put("/commentWrite.do", new CommentWriteAction());
		map.put("/commentDelete.do", new CommentDeleteAction());
		map.put("/commentEditForm.do", new CommentEditFormAction());
		map.put("/commentEdit.do", new CommentEditAction());
		
	} // 생성자
	
	
	
	public Action getAction(String command) {
		Action action = map.get(command);
		
		return action;
	} // getAction method

} // ActionFactory class
