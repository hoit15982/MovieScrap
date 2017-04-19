package com.main.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.main.dto.PopupVO;
import com.util.DBManager;

public class PopupDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private final static String TABLE = "popup";
	
	private static PopupDAO instacne = new PopupDAO();
	private PopupDAO(){}
	public static PopupDAO getInstance(){
		return instacne;
	}
	
	//PopupVO 리스트 가져오기
	public ArrayList<PopupVO> getPopupList(){
		ArrayList<PopupVO> list = new ArrayList<>();
		String sql = "SELECT * FROM "+ TABLE + "";
		PopupVO pVo = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				pVo = new PopupVO();
				pVo.setPo_idx(rs.getInt("po_idx"));
				pVo.setPo_device(rs.getString("po_device"));
				pVo.setPo_begin_time(rs.getTimestamp("po_begin_time"));
				pVo.setPo_end_time(rs.getTimestamp("po_end_time"));
				pVo.setPo_disable_hours(rs.getInt("po_disable_hours"));
				pVo.setPo_left(rs.getInt("po_left"));
				pVo.setPo_top(rs.getInt("po_top"));
				pVo.setPo_height(rs.getInt("po_height"));
				pVo.setPo_width(rs.getInt("po_width"));
				pVo.setPo_subject(rs.getString("po_subject"));
				pVo.setPo_content(rs.getString("po_content"));
				
				list.add(pVo);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage()+"팝업 리스트 불러오기 에러");
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// po_idx 로  popup 데이터 불러오기
	public PopupVO getPopup(int po_idx) {
		// TODO Auto-generated method stub
		PopupVO pVo = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+ TABLE+" WHERE po_idx = ?";
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, po_idx);
			rs = pstmt.executeQuery();
			
			if( rs.next() ){
				pVo = new PopupVO();
				pVo.setPo_idx(rs.getInt("po_idx"));
				pVo.setPo_device(rs.getString("po_device"));
				pVo.setPo_begin_time(rs.getTimestamp("po_begin_time"));
				pVo.setPo_end_time(rs.getTimestamp("po_end_time"));
				pVo.setPo_disable_hours(rs.getInt("po_disable_hours"));
				pVo.setPo_left(rs.getInt("po_left"));
				pVo.setPo_top(rs.getInt("po_top"));
				pVo.setPo_height(rs.getInt("po_height"));
				pVo.setPo_width(rs.getInt("po_width"));
				pVo.setPo_subject(rs.getString("po_subject"));
				pVo.setPo_content(rs.getString("po_content"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage()+" 팝업 idx 로 불러오기 ");
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return pVo;
	}
	
	//팝업 정보 넣기
	public int insertPopup(PopupVO pVo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO "+ TABLE + " VALUES( ";
			   sql+= " POPUP_SEQ.NEXTVAL, ";
			   sql+= " ?, "; //po_device
			   sql+= " ?, "; //po_begin_time
			   sql+= " ?, "; //po_end_time
			   sql+= " ?, "; //po_disable_hours
			   sql+= " ?, "; //po_left
			   sql+= " ?, "; //po_top
			   sql+= " ?, "; //po_height
			   sql+= " ?, "; //po_width
			   sql+= " ?, "; //po_subject
			   sql+= " ? "; //po_content
			   sql+= " ) ";
		int result = 0;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getPo_device());
			pstmt.setTimestamp(2, (Timestamp) pVo.getPo_begin_time());
			pstmt.setTimestamp(3, (Timestamp) pVo.getPo_end_time());
			pstmt.setInt(4, pVo.getPo_disable_hours());
			pstmt.setInt(5, pVo.getPo_left());
			pstmt.setInt(6, pVo.getPo_top());
			pstmt.setInt(7, pVo.getPo_height());
			pstmt.setInt(8, pVo.getPo_width());
			pstmt.setString(9, pVo.getPo_subject());
			pstmt.setString(10, pVo.getPo_content());
			
			result = pstmt.executeUpdate();
	
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(conn, pstmt, null);
		}
		return result;
	}
	
	
	//업데이트
	public int updatePopup(PopupVO pVo) {
		// TODO Auto-generated method stub
		String sql = " UPDATE popup SET ";
			   sql+= " po_device = ?, "; //po_device
			   sql+= " po_begin_time = ?, "; //po_begin_time
			   sql+= " po_end_time = ?, "; //po_end_time
			   sql+= " po_disable_hours = ?, "; //po_disable_hours
			   sql+= " po_left = ?, "; //po_left
			   sql+= " po_top = ?, "; //po_top
			   sql+= " po_height = ?, "; //po_height
			   sql+= " po_width = ?, "; //po_width
			   sql+= " po_subject = ?, "; //po_subject
			   sql+= " po_content = ? "; //po_content
			   sql+= " WHERE po_idx = ?";
		int result = 0;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getPo_device());
			pstmt.setTimestamp(2, (Timestamp) pVo.getPo_begin_time());
			pstmt.setTimestamp(3, (Timestamp) pVo.getPo_end_time());
			pstmt.setInt(4, pVo.getPo_disable_hours());
			pstmt.setInt(5, pVo.getPo_left());
			pstmt.setInt(6, pVo.getPo_top());
			pstmt.setInt(7, pVo.getPo_height());
			pstmt.setInt(8, pVo.getPo_width());
			pstmt.setString(9, pVo.getPo_subject());
			pstmt.setString(10, pVo.getPo_content());
			pstmt.setInt(11, pVo.getPo_idx());
			result = pstmt.executeUpdate();
	
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+"팝업 업데이트 오류");
		}finally {
			DBManager.close(conn, pstmt, null);
		}
		return result;
	}

}
