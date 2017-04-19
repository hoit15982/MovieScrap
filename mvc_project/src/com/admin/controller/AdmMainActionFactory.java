package com.admin.controller;

import com.admin.controller.action.AdmMainAction;
import com.login.controller.action.AdmAction;
import com.login.controller.action.AdmLoginAction;
import com.login.controller.action.AdmLoginOKAction;
import com.login.controller.action.AdmLogoutAction;

public class AdmMainActionFactory {
	static private AdmMainActionFactory instance = new AdmMainActionFactory();
	static public AdmMainActionFactory getInstance(){
		return instance;
	}
	private AdmMainActionFactory(){}
	
	
	public AdmAction getAction(String command){
		AdmAction action = null;
		if( command.equals("/adm/main") ){
			action = new AdmMainAction();
		}
		return action;
	}
}
