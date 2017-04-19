package com.admin.controller;

import com.menu.controller.action.MenuAction;
import com.menu.controller.action.MenuDeleteAction;
import com.menu.controller.action.MenuListAction;
import com.menu.controller.action.MenuWriteAction;
import com.menu.controller.action.MenuWriteOkAction;

public class MenuActionFactory {
	static private MenuActionFactory instance = new MenuActionFactory();
	private MenuActionFactory(){}
	public static MenuActionFactory getInstance(){
		return instance;
	}
	
	public MenuAction getMenuAction(String command){
		MenuAction action = null;
		if( command.equals("/adm/menu/write.do")){
			action = new MenuWriteAction();
		}
		if( command.equals("/adm/menu/writeOk.do")){
			action = new MenuWriteOkAction();
		}		
		if( command.equals("/adm/menu/list.do")){
			action = new MenuListAction();
		}	
		if( command.equals("/adm/menu/delete.do")){
			action = new MenuDeleteAction();
		}			
		return action;
	}
	
	
}
