package net.movie.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movie.db.MovieBean;
import net.movie.db.MovieDAO;

public class MovieMainRankAction implements MAction {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MActionForward forward = new MActionForward();
		
		MovieDAO moviedao = MovieDAO.getInstance();
		MovieBean moviedata = new MovieBean();
		
		int rankcount = moviedao.getMainRank();
		
		return null;
	}

}
