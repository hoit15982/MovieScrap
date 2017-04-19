package com.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.controller.action.BoardAction;
import com.board.controller.action.BoardCheckPassAction;
import com.board.controller.action.BoardDeleteAction;
import com.board.controller.action.BoardListAction;
import com.board.controller.action.BoardReplyAction;
import com.board.controller.action.BoardViewAction;
import com.board.controller.action.BoardWriteAction;
import com.board.controller.action.BoardWriteOkAction;

public class BoardAdmActionFactory {
	static public BoardAdmActionFactory instance = new BoardAdmActionFactory();
	private BoardAdmActionFactory(){}
	static public BoardAdmActionFactory getInstance(){
		return instance;
	}
	public BoardAction getBoardAction(String command){
		BoardAction action =  null;
		
		if( command.equals("/adm/board/list.do") ){
			action = new BoardListAction();
		}
		if( command.equals("/adm/board/view.do") ){
			action = new BoardViewAction();
		}
		if( command.equals("/adm/board/boardCheckPass.do")){
			action = new BoardCheckPassAction();
		}
		if( command.equals("/adm/board/delete.do")){
			action = new BoardDeleteAction();
		}		
		if( command.equals("/adm/board/write.do") || command.equals("/adm/board/update.do") ){
			action = new BoardWriteAction();
		}
		if( command.equals("/adm/board/writeOk.do") ){
			action = new BoardWriteOkAction();
		}
		if( command.equals("/adm/board/reply.do") ){
			action = new BoardReplyAction();
		}		
		return action;
	}
}
