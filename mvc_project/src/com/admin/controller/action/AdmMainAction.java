package com.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.login.controller.action.AdmAction;

public class AdmMainAction implements AdmAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if( session.getAttribute("ss_adminVo") == null ){
			response.sendRedirect("adm/login/login.do");
			return;
		}else{
			System.out.println("dd");
			String url = "/admin/main/main.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
