package com.login.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

public class AdmLoginAction implements AdmAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로그인 세션 검색
		HttpSession session = request.getSession();
		if( session.getAttribute("ss_adminVO") == null ){
			String url = "/admin/login/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 상태입니다.');");
			out.println("</script>");
			out.close();
			response.sendRedirect(request.getContextPath()+"/adm/main");
		}
	}

}
