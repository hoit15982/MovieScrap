package net.movie.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MovieDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public MovieDAO() {	// DB 연결 확인
		try{
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		}catch (Exception ex) {
			System.out.println("DB Connection fail :"+ex);
			return;
		}
	}
	
	//스크랩하기 버튼 눌럿을때
	public boolean MSScrap(MovieBean movie){
		String sql = "insert into MovieScrap values(?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, movie.getMs_no());
			pstmt.setString(2, movie.getMb_id());
			pstmt.setString(3, movie.getMs_title());
			pstmt.setString(4, movie.getMs_subtitle());
			pstmt.setString(5, movie.getMs_director());
			pstmt.setString(6, movie.getMs_actor());
			pstmt.setInt(7, movie.getMs_pubDate());
			pstmt.setInt(8, movie.getMs_userRating());
			pstmt.setString(9, movie.getMs_img());
			pstmt.setString(10, movie.getMs_story());
			pstmt.setString(11, movie.getMs_review());
			
			result = pstmt.executeUpdate();
			if(result != 0){
				return true;
			}
		} catch (Exception e) {
			System.out.println("MSReview ERROR : "+e);
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
			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(ms_no) from moviescrap");
			rs = pstmt.executeQuery();
			if(rs.next()){
				num = rs.getInt(1)+1;
			} else {
				num =1;
			}
			sql = "insert into moviescrap (ms_no, mb_id, ms_title, ms_subtitle, "
					+ " ms_director, ms_actor, ms_pubDate, ms_userRating,"
					+ " ms_myRating, ms_img, ms_story, ms_review, ms_regdate) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, movie.getMb_id());
			pstmt.setString(3, movie.getMs_title());
			pstmt.setString(4, movie.getMs_subtitle());
			pstmt.setString(5, movie.getMs_director());
			pstmt.setString(6, movie.getMs_actor());
			pstmt.setInt(7, movie.getMs_pubDate());
			pstmt.setInt(8, movie.getMs_userRating());
			pstmt.setString(9, movie.getMs_img());
			pstmt.setString(10, movie.getMs_story());
			pstmt.setString(11, movie.getMs_review());
			
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
}
