package com.main.controller;

import com.page.controller.action.PageAboutAction;
import com.page.controller.action.PageAction;

public class PageActionFactory {
	private static String path = "/pf";
	static private PageActionFactory instance = new PageActionFactory();
	private PageActionFactory(){
	}
	static public PageActionFactory getInstance(){
		return instance;
	}
	
	public PageAction getPageAction(String command){
		PageAction action = null;
		if(command.equals(path+"/page/about")){
			action = new PageAboutAction();
		}
		return action;
	}
}
