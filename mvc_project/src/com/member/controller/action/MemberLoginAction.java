package com.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.main.controller.action.Action;
		
public class MemberLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로그인 세션 검색
		HttpSession session = request.getSession();	
		String contextPath = request.getContextPath();
		
		if( session.getAttribute("ss_mb_id") == null ){
			//세션이 존재하지 않으면 로그인 페이지로 이동
			String url = "/login/loginForm.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		}else{
			//세션이 존재하면 메인페이지로 이동
			response.sendRedirect(contextPath+"/index.do");
		}
		
	}

}
