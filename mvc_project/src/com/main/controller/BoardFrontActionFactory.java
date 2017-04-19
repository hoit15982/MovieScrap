package com.main.controller;


import com.board.front.controller.action.BoardFrontCheckPassAction;
import com.board.front.controller.action.BoardFrontDeleteAction;
import com.board.front.controller.action.BoardFrontListAction;
import com.board.front.controller.action.BoardFrontReplyAction;
import com.board.front.controller.action.BoardFrontViewAction;
import com.board.front.controller.action.BoardFrontWriteAction;
import com.board.front.controller.action.BoardFrontWriteOkAction;
import com.main.controller.action.Action;

public class BoardFrontActionFactory {
	private static String path = "/pf";
	private static BoardFrontActionFactory instance = new BoardFrontActionFactory();
	private BoardFrontActionFactory(){}
	public static BoardFrontActionFactory getInstance(){
		return instance;
	}
	
	public Action getBoardAction(String command){
		System.out.println(command);
		Action action = null;
		
		if( command.equals(path+"/board/list.do") ){
			action = new BoardFrontListAction();
		}
		if( command.equals(path+"/board/view.do") ){
			action = new BoardFrontViewAction();
		}
		if( command.equals(path+"/board/boardCheckPass.do")){
			action = new BoardFrontCheckPassAction();
		}
		if( command.equals(path+"/board/delete.do")){
			action = new BoardFrontDeleteAction();
		}		
		if( command.equals(path+"/board/write.do") || command.equals(path+"/board/update.do") ){
			action = new BoardFrontWriteAction();
		}
		if( command.equals(path+"/board/writeOk.do") ){
			action = new BoardFrontWriteOkAction();
		}
		if( command.equals(path+"/board/reply.do") ){
			action = new BoardFrontReplyAction();
		}		
		return action;
	}
}
