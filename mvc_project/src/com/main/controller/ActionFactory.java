package com.main.controller;
import com.main.controller.action.Action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory(){
		super();
	}
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command) {
		// TODO Auto-generated method stub
		Action action = null;
		if(command.equals("")){
			
		}
		
		return null;
	}
	
}
