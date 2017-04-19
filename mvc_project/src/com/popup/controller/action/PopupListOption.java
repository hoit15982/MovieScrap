package com.popup.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.dao.BoardOptionDao;
import com.main.dao.PopupDAO;
import com.main.dto.BoardOptionVO;
import com.main.dto.PopupVO;

public class PopupListOption implements PopupOption {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<PopupVO> list = null;
		
		String url = "/adm/setting/popup_list.jsp";
		PopupDAO pDao = PopupDAO.getInstance();

		list = pDao.getPopupList();
		
		request.setAttribute("totalCount", list.size()); //전체 갯수
		request.setAttribute("popupList", list); //리스트
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}

}
