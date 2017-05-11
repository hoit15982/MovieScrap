package net.movie.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movie.db.MovieBean;
import net.movie.db.MovieDAO;

public class MovieScrapAction {
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MovieDAO moviedao = new MovieDAO();
		MovieBean moviedata = new MovieBean();
		MActionForward mforward = new MActionForward();
		
		boolean result = false;
		
		try {
			moviedata.setMb_id(request.getParameter(""));
			moviedata.setms_
			
		} catch (Exception e) {
			
		}
		return null;
	}
}
