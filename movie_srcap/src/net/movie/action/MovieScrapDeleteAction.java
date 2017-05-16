package net.movie.action;

import java.io.PrintWriter;
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
		boolean isScrapWriter = false;
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			//seq - movieSeq / id - movieid 값 받음
			String mb_id = "namhy";
			String ms_seq = request.getParameter("seq") == null ? "" : request.getParameter("seq");
			String ms_id = request.getParameter("id") == null ? "" : request.getParameter("id");
			
			isScrapWriter = moviedao.isScrapWriter(mb_id, ms_seq, ms_id);
			if(isScrapWriter == false){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제할 권한이 없습니다');");
				out.println("./MovieScrapView.mv?id="+ms_id+"&seq="+ms_seq);
				out.println("</script>");
				out.close();
				return null;
			}
			moviedata.setMb_id(mb_id);
			moviedata.setMs_seq(ms_seq);
			moviedata.setMs_id(ms_id);
			
			result = moviedao.MSScrapDelete(moviedata);
			
			
			if(result == false){
				System.out.println("스크랩 삭제 실패 !!");
				return null;
			} 
			
			System.out.println("스크랩 삭제 성공!!!");
			
			forward.setRedirect(true);
			forward.setPath("./MovieScrapView.mv?id="+ms_id+"&seq="+ms_seq);
			return forward;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
