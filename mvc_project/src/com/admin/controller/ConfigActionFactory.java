package com.admin.controller;

import com.config.controller.action.ConfigAction;
import com.config.controller.action.ConfigAdmWriteAction;
import com.config.controller.action.ConfigAdmWriteOkAction;


public class ConfigActionFactory {

	private static ConfigActionFactory instance = new ConfigActionFactory();
	private ConfigActionFactory(){}
	public static ConfigActionFactory getInstance(){
		return instance;
	}
	
	public ConfigAction getConfigAction(String command){
		ConfigAction action = null;
		
		if( command.equals("/adm/config/write.do")){
			action = new ConfigAdmWriteAction();
		}
		if( command.equals("/adm/config/writeOk.do")){
			action = new ConfigAdmWriteOkAction();
		}		
		return action;
	}
	
}
