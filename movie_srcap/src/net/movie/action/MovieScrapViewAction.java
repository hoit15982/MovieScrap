package net.movie.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movie.db.MovieDAO;

public class MovieScrapViewAction implements MAction {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MActionForward mforward = new MActionForward();
		
		request.setCharacterEncoding("UTF-8");
		
		//seq - movieSeq / id - movieid 값 받음
		String seq = request.getParameter("seq") == null ? "" : request.getParameter("seq");
		String id = request.getParameter("id") == null ? "" : request.getParameter("id");
		
		//API 검색 설정
		MovieAPI mApi = new MovieAPI();
		mApi.setSearch("movieSeq");
		mApi.setStx(seq);
		mApi.setSearch2("movieId");
		mApi.setStx2(id);
		
		//검색한 영화 데이터 가져오기.
		MovieDAO mDao = MovieDAO.getInstance();
		ArrayList<Movie> movieList = mDao.getMovieList(mApi.getResult());
		Movie movie = movieList.get(0);
		request.setAttribute("movie", movie);
		
		System.out.println(mApi.getResult());
		//view 설정
		mforward.setRedirect(false);
		mforward.setPath("movie/movie_view.jsp");
		
		return mforward;
		
	}

}
