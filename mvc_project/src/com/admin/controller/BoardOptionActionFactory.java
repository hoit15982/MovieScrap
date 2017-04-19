package com.admin.controller;

import javax.servlet.http.HttpServletRequest;

import com.member.controller.action.MemberLoginAction;
import com.option.controller.action.BoardOptionAction;
import com.option.controller.action.BoardOptionDeleteAction;
import com.option.controller.action.BoardOptionListAction;
import com.option.controller.action.BoardOptionUpdateAction;
import com.option.controller.action.BoardOptionWriteAction;
import com.option.controller.action.BoardOptionWriteOKAction;

public class BoardOptionActionFactory {
	private static BoardOptionActionFactory instance = new BoardOptionActionFactory();
	public static BoardOptionActionFactory getInstacne() {
		// TODO Auto-generated method stub
		return instance;
	}
	private BoardOptionActionFactory(){}
	
	public BoardOptionAction getBoardOptionAction(String command){
		BoardOptionAction action = null;
		System.out.println("factroy : "+ command);
		
		//입력
		if( command.equals("/adm/boardOption/write.do")){
			action = new BoardOptionWriteAction();
		}
		//리스트
		if( command.equals("/adm/boardOption/list.do")){
			action = new BoardOptionListAction();
		}
		//수정
		if( command.equals("/adm/boardOption/update.do")){
			action = new BoardOptionUpdateAction();
		}
		//수정 및 등록
		if( command.equals("/adm/boardOption/writeOk.do")){
			action = new BoardOptionWriteOKAction();
		}
		//삭제
		if( command.equals("/adm/boardOption/delete.do")){
			action = new BoardOptionDeleteAction();
		}
		return action;
	}


}
