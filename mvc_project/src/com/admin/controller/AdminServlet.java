package com.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.main.controller.BoardFrontActionFactory;
import com.main.controller.MemberActionFactory;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adm/*")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		System.out.println(command);
		String [] path = command.split("/");
		System.out.println("dd");
		if( path[2].equals("member")){
			System.out.println("ddd");
			AdmMemberActionFactory factory = AdmMemberActionFactory.getInstance();
			factory.getAction(command).execute(request, response);	
		}else if( path[2].equals("login")){
			AdmLoginActionFactory factory = AdmLoginActionFactory.getInstance();
			factory.getAction(command).execute(request, response);	
		}else if( path[2].equals("main")){
			AdmMainActionFactory factory = AdmMainActionFactory.getInstance();
			factory.getAction(command).execute(request, response);
		}else if( path[2].equals("board")){
			BoardAdmActionFactory factory = BoardAdmActionFactory.getInstance();
			factory.getBoardAction(command).execute(request, response);
		}else if(path[2].equals("config")){
			ConfigActionFactory factory = ConfigActionFactory.getInstance();
			factory.getConfigAction(command).execute(request, response);
		}else if( path[2].equals("menu")){
			MenuActionFactory factroy = MenuActionFactory.getInstance();
			factroy.getMenuAction(command).execute(request, response);
		}else if( path[2].equals("boardOption")){
			BoardOptionActionFactory factory = BoardOptionActionFactory.getInstacne();
			factory.getBoardOptionAction(command).execute(request, response);			
		}else if( path[2].equals("popup")){
			PopupOptionFactory factory = PopupOptionFactory.getInstacne();
			factory.getPopupOption(command).execute(request, response);				
		}
	}
}
