package net.movie.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movie.action.MovieScrapAction;
import net.movie.action.MAction;
import net.movie.action.MActionForward;

public class MovieFrontController {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		MActionForward forward = null;
		MAction action = null;
		
		if(command.equals("/MovieScrap.bo")){
			action = new MovieScrapAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} else if(command.equals("/MovieReview.bo")){
			
		} else if(command.equals("/MoviewModify.bo")){
			
		} else if(command.equals("/MovieDelete.bo")){
			
		} else if(command.equals("/MovieScrapList.bo")){
			
		}
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		System.out.println("board");
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		doProcess(request,response);
	}
}
