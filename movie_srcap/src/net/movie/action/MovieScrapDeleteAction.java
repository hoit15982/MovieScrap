package net.movie.action;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movie.db.MovieAPI;
import net.movie.db.MovieBean;
import net.movie.db.MovieDAO;

public class MovieScrapDeleteAction implements MAction {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MovieDAO moviedao =  MovieDAO.getInstance();
		MovieBean moviedata = new MovieBean();
		MActionForward forward = new MActionForward();
		
		boolean result = false;
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			//seq - movieSeq / id - movieid 값 받음
			String seq = request.getParameter("seq") == null ? "" : request.getParameter("seq");
			String id = request.getParameter("id") == null ? "" : request.getParameter("id");
			
			
			
			
			if(result == false){
				System.out.println("스크랩 삭제 실패 !!");
				return null;
			} 
			
			System.out.println("스크랩 삭제 성공!!!");
			
			forward.setRedirect(true);
			forward.setPath("./MovieScrapView.mv?id="+id+"&seq="+seq);
			return forward;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
