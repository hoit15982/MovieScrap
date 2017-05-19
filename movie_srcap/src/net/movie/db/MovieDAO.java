package net.movie.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	//스크랩
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
			
			sql = "insert into MovieScrap (ms_no, mb_id, ms_title, "
					+ " ms_director, ms_poster, ms_regdate,"
					+ " ms_rating, ms_seq, ms_id) "
					+ "values(?,?,?,?,?,sysdate,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, movie.getMb_id());
			pstmt.setString(3, movie.getMs_title());
			pstmt.setString(4, movie.getMs_director());
			pstmt.setString(5, movie.getMs_poster());
			pstmt.setString(6, movie.getMs_rating());
			pstmt.setString(7, movie.getMs_seq());
			pstmt.setString(8, movie.getMs_id());
			
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
	
	//스크랩 삭제
	public boolean MSScrapDelete(MovieBean movie){
		String sql = "";
		int result = 0;
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement("delete from MovieScrap where mb_id=? and ms_seq=? and ms_id=?");
			pstmt.setString(1, movie.getMb_id());
			pstmt.setString(2, movie.getMs_seq());
			pstmt.setString(3, movie.getMs_id());
			
			result = pstmt.executeUpdate();
			if(result != 0){
				return true;
			}
		} catch (Exception e) {
			System.out.println("MSScrapDelete ERROR : "+e);
		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException ex){}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException ex){}
			if(con!=null) try { con.close();} catch(SQLException ex){}
		}
		return false;
	}
	
	
	//스크랩 체크
	public boolean MSScrapCheck(String mb_id, String ms_seq, String ms_id){
		String sql = "select * from MovieScrap where mb_id=? and ms_seq=? and ms_id=?";
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			pstmt.setString(2, ms_seq);
			pstmt.setString(3, ms_id);
			rs = pstmt.executeQuery();
			if (rs.next()){
				System.out.println("중복된 영화입니다");
				return false;
			}
		} catch (Exception e) {
			System.out.println("스크랩 중복 체크 에러 : "+e);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
			}
		}
		return true;
	}
	
	
	//스크랩 삭제 체크 ( 스크랩안되있는데 삭제버튼을 누른경우)
	public boolean MSScrapDeleteCheck(String mb_id, String ms_seq, String ms_id){
		String sql = "select * from MovieScrap where mb_id=? and ms_seq=? and ms_id=?";
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			pstmt.setString(2, ms_seq);
			pstmt.setString(3, ms_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
			} else {
				System.out.println("스크랩 안된 영화입니다");
				return true;
			}
		} catch (Exception e) {
			System.out.println("스크랩 안된 영화 삭제 에러 : "+e);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
			}
		}
		return false;
	}
	
	
	//리뷰 작성
	public boolean MSReview(MovieBean movie){
		int num = 0;
		String sql="";
		int result = 0;
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(ms_no) from MovieReview");
			rs = pstmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1)+1;
			} else {
				num = 1;
			}
			
			sql = "insert into MovieReview (ms_no, mb_id, "
					+ " ms_myrating, ms_review, ms_seq, ms_id, ms_regdate) "
					+ "values(?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, movie.getMb_id());
			pstmt.setInt(3, movie.getMs_myRating());
			pstmt.setString(4, movie.getMs_review());
			pstmt.setString(5, movie.getMs_seq());
			pstmt.setString(6, movie.getMs_id());
			
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
	
	
	//리뷰 삭제
	public boolean MSReviewdelete(MovieBean movie){
		int num = 0;
		String sql="";
		int result = 0;
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(ms_no) from MovieReview");
			rs = pstmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1)+1;
			} else {
				num = 1;
			}
			
			sql = "delete from MovieReview where mb_id=? and ms_seq=? and ms_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movie.getMb_id());
			pstmt.setString(2, movie.getMs_seq());
			pstmt.setString(3, movie.getMs_id());
			
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
	
	
	/*//글쓴이 인지 확인
	public boolean isScrapWriter(String mb_id, String ms_seq, String ms_id){
		System.out.println("mb_id="+mb_id);
		System.out.println("ms_seq="+ms_seq);
		System.out.println("ms_id="+ms_id);
		String sql = "select * from MovieScrap where "
				+ " mb_id=? and ms_seq=? and ms_id=?";
		
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			pstmt.setString(2, ms_seq);
			pstmt.setString(3, ms_id);
			rs = pstmt.executeQuery();
			rs.next();
			
			if(mb_id.equals("namhy")){
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("isScrapWriter Error : "+e);
			System.out.println(e.toString());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
			}
		}
		return false;
	}*/
	
	//스크랩 갯수 확인(로그인한 사람아이디값으로 체크)
	public int getScrapCount(String mb_id){
		int x = 0;
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement("select count(*) from MovieScrap where mb_id=?");
			pstmt.setString(1, mb_id);
			rs = pstmt.executeQuery();
			if(rs.next()) x = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("getScrapList Error : "+e);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
			}
		}
		return x;
	}
	
	
	//스크랩한 리스트 보기
	public List getScrapList(int page, int limit, String mb_id){
		String sql = "";
		sql = "select * from (select rownum rnum, ms_no, mb_id, ms_title, ms_director, "
				+ "ms_poster, ms_regdate, ms_rating, ms_seq, ms_id from (select * from "
				+ "moviescrap where mb_id=?)) where rnum>=? and rnum<=?";
		
		List list = new ArrayList();
		int startrow = (page -1)*10+1;
		int endrow = startrow+limit-1;
		
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, endrow);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				MovieBean movie = new MovieBean();
				movie.setMs_no(rs.getInt("ms_no"));
				movie.setMb_id(rs.getString("mb_id"));
				movie.setMs_title(rs.getString("ms_title"));
				movie.setMs_director(rs.getString("ms_director"));
				movie.setMs_poster(rs.getString("ms_poster"));
				movie.setMs_rating(rs.getString("ms_rating"));
				movie.setMs_seq(rs.getString("ms_seq"));
				movie.setMs_id(rs.getString("ms_id"));
				movie.setMs_regdate(rs.getDate("ms_regdate"));
				
				list.add(movie);
			}
			return list;
		} catch (Exception e) {
			System.out.println("getScrapList Error : "+e);
		} finally {
			if(rs!=null) try{rs.close();} catch(SQLException e){}
			if(pstmt!=null) try{pstmt.close();} catch(SQLException e){}
			if(con!=null) try{con.close();} catch(SQLException e){}
		}
		return null;
	}
	
	public int getMainRank(){
		int x = 0;
		
		try {
			connection();
			con = ds.getConnection();
			pstmt = con.prepareStatement("select ms_title, count(*)"
					+ " from MovieScrap group by ms_title order by count(*) desc");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) x = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("getMainRank Error : "+e);
		} finally {
			if(rs!=null) try{rs.close();} catch(SQLException e){}
			if(pstmt!=null) try{pstmt.close();} catch(SQLException e){}
			if(con!=null) try{con.close();} catch(SQLException e){}
		}
		return x;
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
					if(resultObject.get("posters").toString().equals("")){
						movie.setPoster("");
					} else {
						movie.setPoster(resultObject.get("posters").toString());
					}
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
