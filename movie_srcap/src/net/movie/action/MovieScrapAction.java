package net.movie.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movie.db.MovieBean;
import net.movie.db.MovieDAO;

public class MovieScrapAction implements MAction{
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		MActionForward mforward = new MActionForward();
		
		request.setCharacterEncoding("UTF-8");
		String key = "아이언맨";
		String apikey = "DE611070AD8C97B8FAE32AFB839EF9CA3E764F776407F406616C6FF56A2";// 애플리케이션 클라이언트 아이디값";

		try {
			/* String text = URLEncoder.encode(apikey, "UTF-8");
			String text2 = URLEncoder.encode(key, "UTF-8"); */
			StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json.jsp?");
			urlBuilder.append(URLEncoder.encode("collection","utf-8")+"="+URLEncoder.encode("kmdb_new", "utf-8"));
			urlBuilder.append("&"+URLEncoder.encode("ServiceKey", "utf-8")+"="+URLEncoder.encode("DE611070AD8C97B8FAE32AFB839EF9CA3E764F776407F406616C6FF56A2", "utf-8"));
			urlBuilder.append("&"+URLEncoder.encode("title", "utf-8")+"="+URLEncoder.encode("아이언맨","utf-8"));
			
		
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + con.getResponseCode());
			
			int responseCode = con.getResponseCode();
			
			BufferedReader rd;
			if (responseCode == 200) { // 정상 호출
				rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				rd = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line.trim());
			}
			request.setAttribute("api", sb.toString());
			rd.close();
			con.disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		mforward.setRedirect(false);
		mforward.setPath("movie/movie_view.jsp");
		
		return mforward;
	}
}
