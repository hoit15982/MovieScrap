package com.admin.controller;

import com.popup.controller.action.PopupListOption;
import com.popup.controller.action.PopupOption;
import com.popup.controller.action.PopupWriteOkOption;
import com.popup.controller.action.PopupWriteOption;

public class PopupOptionFactory {
	private static PopupOptionFactory instance = new PopupOptionFactory();
	public static PopupOptionFactory getInstacne() {
		// TODO Auto-generated method stub
		return instance;
	}
	private PopupOptionFactory(){}
	
	
	public PopupOption getPopupOption(String command) {
		// TODO Auto-generated method stub
		PopupOption option = null;
		
		if( command.equals("/adm/popup/list.do")){
			option = new PopupListOption();
		}
		if( command.equals("/adm/popup/write.do")){
			option = new PopupWriteOption();
		}
		if( command.equals("/adm/popup/writeOk.do")){
			option = new PopupWriteOkOption();
		}			
		return option;
	}
}
