package com.admin.controller;

import com.main.controller.action.Action;
import com.member.controller.action.MemberAdmDeleteAction;
import com.member.controller.action.MemberAdmListAction;
import com.member.controller.action.MemberAdmOutAction;
import com.member.controller.action.MemberAdmWriteAction;
import com.member.controller.action.MemberAdmWriteOKAction;


public class MemberAdmActionFactory {
	private static MemberAdmActionFactory instance = new MemberAdmActionFactory();
	private MemberAdmActionFactory(){}
	public static MemberAdmActionFactory getInstance(){
		return instance;
	}
	
	public Action getMemberAdmAction(String command){
		Action action = null; 
		
		if( command.equals("/adm/member/list.do")){
			action = new MemberAdmListAction();
		}
		
		if( command.equals("/adm/member/write.do")){
			action = new MemberAdmWriteAction();
		}

		if( command.equals("/adm/member/writeOk.do")){
			action = new MemberAdmWriteOKAction();
		}
		
		if( command.equals("/adm/member/delete.do")){
			action = new MemberAdmDeleteAction();
		}	
		
		if( command.equals("/adm/member/out.do")){
			action = new MemberAdmOutAction();
		}			
		return action;
	}
}
