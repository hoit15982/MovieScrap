package net.movie.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import jdk.nashorn.api.scripting.JSObject;
import net.movie.action.Movie;

public class MovieDAO {
	static private MovieDAO instance = null;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private MovieDAO() {}

	
	static public MovieDAO getInstance(){
		if( instance == null ){
			instance = new MovieDAO();
		}
		return instance;
	}
	
	public void connection(){
		try{
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		}catch (Exception ex) {
			System.out.println("DB Connection fail :"+ex);
			return;
		}
	}
	
	//스크랩하기 버튼 눌럿을때 내용은 저장 x 리뷰할때 리뷰내용 저장되게 구성
	public boolean MSScrap(MovieBean movie){
		String sql = "";
		int result = 0;
		int num = 0;
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(ms_no) from MovieScrap");
			rs = pstmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1)+1;
			} else {
				num = 1;
			}
			
			sql = "insert into MovieScrap (ms_no, mb_id, ms_title, ms_subtitle, "
					+" ms_director, ms_poster, ms_myRating, "
					+" ms_review, ms_regdate, ms_rating, ms_seq, ms_id) "
					+"values(?,?,?,?,?,?,?,?,sysdate,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, movie.getMb_id());
			pstmt.setString(3, movie.getMs_title());
			pstmt.setString(4, movie.getMs_subtitle());
			pstmt.setString(5, movie.getMs_director());
			pstmt.setString(6, movie.getMs_poster());
			pstmt.setInt(7, movie.getMs_myRating());
			pstmt.setString(8, movie.getMs_review());
			pstmt.setString(9, movie.getMs_rating());
			pstmt.setString(10, movie.getMs_seq());
			pstmt.setString(11, movie.getMs_id());
			
			result = pstmt.executeUpdate();
			if(result != 0){
				return true;
			}
		} catch (Exception e) {
			System.out.println("MSScrap ERROR : "+e);
		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException ex){}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex){}
			if(con!=null) try { con.close();} catch(SQLException ex){}
		}
		return false;
	}
	
	
	//리뷰 업데이트
	public boolean MSReview(MovieBean movie){
		int num = 0;
		String sql="";
		int result = 0;
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(ms_no) from moviescrap");
			rs = pstmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1)+1;
			} else {
				num =1;
			}
			sql = "insert into moviescrap (ms_no, mb_id, ms_title, ms_subtitle, "
					+ " ms_director, ms_actor, ms_pubDate, "
					+ " ms_myRating, ms_img, ms_story, ms_review, ms_regdate) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			/*pstmt.setInt(1, num);
			pstmt.setString(2, movie.getMb_id());
			pstmt.setString(3, movie.getMs_title());
			pstmt.setString(4, movie.getMs_subtitle());
			pstmt.setString(5, movie.getMs_director());
			pstmt.setString(6, movie.getMs_actor());
			pstmt.setInt(7, movie.getMs_pubDate());
			pstmt.setInt(8, movie.getMs_userRating());
			pstmt.setString(9, movie.getMs_img());
			pstmt.setString(10, movie.getMs_story());
			pstmt.setString(11, movie.getMs_review());*/
			
			result = pstmt.executeUpdate();
			if(result == 0) return false;
			
			return true;
		} catch (Exception e) {
			System.out.println("Review Error : "+e);
		} finally {
			if(rs!=null) try{rs.close();} catch(SQLException e){}
			if(pstmt!=null) try{pstmt.close();} catch(SQLException e){}
			if(con!=null) try{con.close();} catch(SQLException e){}
		}
		return false;
	}
	
	//영화 API 파싱 리스트 
	public ArrayList<Movie> getMovieList(String data){
		ArrayList<Movie> list = new ArrayList<>();
		Movie movie = null;
		try {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject  = (JSONObject) jsonParser.parse(data);
		JSONArray dataArray = (JSONArray) jsonObject.get("Data");
		
		JSONObject dataObject = (JSONObject) dataArray.get(0);
		if( dataObject != null ){
			JSONArray resultArray = (JSONArray) dataObject.get("Result");
			
			if( resultArray != null ){
				for( int i = 0; i< resultArray.size(); i++ ){
					JSONObject resultObject = (JSONObject) resultArray.get(i);
					movie = new Movie();
					movie.setTitle(resultObject.get("title").toString().replaceAll(" !HE ", "").replaceAll(" !HS ", "")); //제목
					movie.setTitleOrg(resultObject.get("titleOrg").toString()); //titleOrg
					
					//감독
					JSONArray directorArray = (JSONArray) resultObject.get("director");
					JSONObject director = (JSONObject) directorArray.get(0);
					movie.setDirector(director.get("directorNm").toString());
					
					//배우
					JSONArray actorArray = (JSONArray) resultObject.get("actor");
					ArrayList<String> actorlist = new ArrayList<>();
					for( int j = 0; j < actorArray.size(); j++ ){
						JSONObject actor = (JSONObject) actorArray.get(j);
						actorlist.add(actor.get("actorNm").toString());
					}
					movie.setActor(actorlist);
					
					//포스터
					movie.setPoster(resultObject.get("posters").toString());
					
					//스틸
					movie.setStlls(resultObject.get("stlls").toString());
					
					//docID
					movie.setDocId(resultObject.get("DOCID").toString());
					
					//movieSeq
					movie.setMovieSeq(resultObject.get("movieSeq").toString());
					
					//movieId
					movie.setMovieId(resultObject.get("movieId").toString());
					
					//prodYear
					movie.setProdYear(resultObject.get("prodYear").toString());
					
					//plot 
					movie.setPlot(resultObject.get("plot").toString());
					
					//company
					movie.setCompany(resultObject.get("company").toString());
					
					//rating
					JSONArray ratingArray = (JSONArray) resultObject.get("rating");
					JSONObject rating = (JSONObject) ratingArray.get(0);
					movie.setRating(rating.get("ratingGrade").toString());
					
					//runtime
					movie.setRuntime(resultObject.get("runtime").toString());
					
					//nation
					movie.setNation(resultObject.get("nation").toString());
					
					//genre
					movie.setGenre(resultObject.get("genre").toString());
					list.add(movie);
				}
			}
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
