package jsp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jsp.common.util.DBConnection;


public class BoardDAO 
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static BoardDAO instance;
	DataSource ds;
	private BoardDAO(){
		
		try{
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		}catch (Exception ex) {
			System.out.println("DB Connection fail :"+ex);
			return;
		}		
	}
	public static BoardDAO getInstance(){
		if(instance==null)
			instance=new BoardDAO();
		return instance;
	}
	
	// �������� �����´�.
	public int getSeq()
	{
		int result = 1;
		
		try {
			conn = ds.getConnection();
			
			// ������ ���� �����´�. (DUAL : ������ ���� ������������ �ӽ� ���̺�)
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT BOARD_NUM.NEXTVAL FROM DUAL");
			
			pstmt = conn.prepareStatement(sql.toString());
			// ���� ����
			rs = pstmt.executeQuery();
			
			if(rs.next())	result = rs.getInt(1);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return result;	
	} // end getSeq
	
	// �� ����
	public boolean boardInsert(BoardBean board)
	{
		boolean result = false;
		
		try {
			conn = ds.getConnection();
			
			// �ڵ� Ŀ���� false�� �Ѵ�.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO MEMBER_BOARD");
			sql.append("(BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE");
			sql.append(", BOARD_RE_REF, BOARD_COUNT, BOARD_DATE, BOARD_PARENT)");
			sql.append(" VALUES(?,?,?,?,?,?,?,sysdate,?)");
			
			int num = board.getBoard_num();			// �۹�ȣ(������ ��)
			int ref = board.getBoard_re_ref(); 		// �׷��ȣ
			int parent = board.getBoard_parent(); 	// �θ�۹�ȣ
			
			// �θ���� ��� �׷��ȣ�� �۹�ȣ ����
			if(parent == 0) ref = num;
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getBoard_id());
			pstmt.setString(3, board.getBoard_subject());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setString(5, board.getBoard_file());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, board.getBoard_count());
			pstmt.setInt(8, parent);

			int flag = pstmt.executeUpdate();
			if(flag > 0){
				result = true;
				conn.commit(); // �Ϸ�� Ŀ��
			}
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} 
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return result;	
	} // end boardInsert();
	
	
	// �۸�� ��������
	public ArrayList<BoardBean> getBoardList(HashMap<String, Object> listOpt)
	{
		ArrayList<BoardBean> list = new ArrayList<BoardBean>();
		
		String opt = (String)listOpt.get("opt");
		String condition = (String)listOpt.get("condition");
		int start = (Integer)listOpt.get("start");
		
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			
			// �۸�� ��ü�� ������ ��
			if(opt == null)
			{
				/*
				 * SELECT * FROM
				 *			(SELECT  ROWNUM AS rnum,
                 *  				 data.*
            	 *			 FROM
                 *   				(SELECT LEVEL,
                 *             			 	BOARD_NUM,
                 *             				BOARD_ID,
                 *            				BOARD_SUBJECT,
                 *             				BOARD_CONTENT,
                 *             				BOARD_FILE,
                 *             				BOARD_COUNT,
                 *             				BOARD_RE_REF,
                 *             				BOARD_PARENT,
                 *             				BOARD_DATE
                 *   				 FROM MEMBER_BOARD
                 *      			 START WITH BOARD_PARENT = 0
                 *      			 CONNECT BY PRIOR BOARD_NUM = BOARD_PARENT
                 *      			 ORDER SIBLINGS BY BOARD_RE_REF desc) 
                 *			 data)
 				 * WHERE rnum>=? and rnum<=? ;
				 */
				
				sql.append("SELECT * FROM");
				sql.append(" (SELECT  ROWNUM AS rnum, data.* FROM ");
				sql.append("	(SELECT LEVEL, BOARD_NUM, BOARD_ID,	BOARD_SUBJECT,");
				sql.append("			BOARD_CONTENT, BOARD_FILE,BOARD_COUNT,");
				sql.append("			BOARD_RE_REF, BOARD_PARENT, BOARD_DATE");
				sql.append("	FROM MEMBER_BOARD");
				sql.append("	START WITH BOARD_PARENT = 0");
				sql.append("	CONNECT BY PRIOR BOARD_NUM = BOARD_PARENT");
				sql.append("	ORDER SIBLINGS BY BOARD_RE_REF desc)");              
				sql.append(" data) ");
				sql.append("WHERE rnum>=? and rnum<=?");

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, start+9);
				
				// StringBuffer�� ����.
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("0")) // �������� �˻�
			{
				sql.append("SELECT * FROM");
				sql.append(" (SELECT  ROWNUM AS rnum, data.* FROM ");
				sql.append("	(SELECT LEVEL, BOARD_NUM, BOARD_ID,	BOARD_SUBJECT,");
				sql.append("			BOARD_CONTENT, BOARD_FILE,BOARD_COUNT,");
				sql.append("			BOARD_RE_REF, BOARD_PARENT, BOARD_DATE");
				sql.append("	FROM MEMBER_BOARD");
				sql.append(" 	WHERE BOARD_SUBJECT like ?");
				sql.append("	START WITH BOARD_PARENT = 0");
				sql.append("	CONNECT BY PRIOR BOARD_NUM = BOARD_PARENT");
				sql.append("	ORDER SIBLINGS BY BOARD_RE_REF desc)");              
				sql.append(" data) ");
				sql.append("WHERE rnum>=? and rnum<=?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("1")) // �������� �˻�
			{
				sql.append("SELECT * FROM");
				sql.append(" (SELECT  ROWNUM AS rnum, data.* FROM ");
				sql.append("	(SELECT LEVEL, BOARD_NUM, BOARD_ID,	BOARD_SUBJECT,");
				sql.append("			BOARD_CONTENT, BOARD_FILE,BOARD_COUNT,");
				sql.append("			BOARD_RE_REF, BOARD_PARENT, BOARD_DATE");
				sql.append("	FROM MEMBER_BOARD");
				sql.append(" 	WHERE BOARD_CONTENT like ?");
				sql.append("	START WITH BOARD_PARENT = 0");
				sql.append("	CONNECT BY PRIOR BOARD_NUM = BOARD_PARENT");
				sql.append("	ORDER SIBLINGS BY BOARD_RE_REF desc)");              
				sql.append(" data) ");
				sql.append("WHERE rnum>=? and rnum<=?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("2")) // ����+�������� �˻�
			{
				sql.append("SELECT * FROM");
				sql.append(" (SELECT  ROWNUM AS rnum, data.* FROM ");
				sql.append("	(SELECT LEVEL, BOARD_NUM, BOARD_ID,	BOARD_SUBJECT,");
				sql.append("			BOARD_CONTENT, BOARD_FILE,BOARD_COUNT,");
				sql.append("			BOARD_RE_REF, BOARD_PARENT, BOARD_DATE");
				sql.append("	FROM MEMBER_BOARD");
				sql.append(" 	WHERE BOARD_SUBJECT like ?");
				sql.append(" 	OR BOARD_CONTENT like ?");
				sql.append("	START WITH BOARD_PARENT = 0");
				sql.append("	CONNECT BY PRIOR BOARD_NUM = BOARD_PARENT");
				sql.append("	ORDER SIBLINGS BY BOARD_RE_REF desc)");              
				sql.append(" data) ");
				sql.append("WHERE rnum>=? and rnum<=?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, start+9);
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("3")) // �۾��̷� �˻�
			{	
				sql.append("SELECT * FROM");
				sql.append(" (SELECT  ROWNUM AS rnum, data.* FROM ");
				sql.append("	(SELECT LEVEL, BOARD_NUM, BOARD_ID,	BOARD_SUBJECT,");
				sql.append("			BOARD_CONTENT, BOARD_FILE,BOARD_COUNT,");
				sql.append("			BOARD_RE_REF, BOARD_PARENT, BOARD_DATE");
				sql.append("	FROM MEMBER_BOARD");
				sql.append(" 	WHERE BOARD_ID like ?");
				sql.append("	START WITH BOARD_PARENT = 0");
				sql.append("	CONNECT BY PRIOR BOARD_NUM = BOARD_PARENT");
				sql.append("	ORDER SIBLINGS BY BOARD_RE_REF desc)");              
				sql.append(" data) ");
				sql.append("WHERE rnum>=? and rnum<=?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				
				sql.delete(0, sql.toString().length());
			}
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				BoardBean board = new BoardBean();
				board.setBoard_re_lev(rs.getInt("LEVEL"));
				board.setBoard_num(rs.getInt("BOARD_NUM"));
				board.setBoard_id(rs.getString("BOARD_ID"));
				board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
				board.setBoard_content(rs.getString("BOARD_CONTENT"));
				board.setBoard_file(rs.getString("BOARD_FILE"));
				board.setBoard_count(rs.getInt("BOARD_COUNT"));
				board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
				board.setBoard_parent(rs.getInt("BOARD_PARENT"));
				board.setBoard_date(rs.getDate("BOARD_DATE"));
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return list;
	} // end getBoardList
	
	

	public int getBoardListCount(HashMap<String, Object> listOpt)
	{
		int result = 0;
		String opt = (String)listOpt.get("opt");
		String condition = (String)listOpt.get("condition");
		
		try {
			conn = ds.getConnection();
			
			StringBuffer sql = new StringBuffer();
			
			if(opt == null)	
			{
				sql.append("select count(*) from MEMBER_BOARD");
				pstmt = conn.prepareStatement(sql.toString());
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("0")) 
			{
				sql.append("select count(*) from MEMBER_BOARD where BOARD_SUBJECT like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("1")) 
			{
				sql.append("select count(*) from MEMBER_BOARD where BOARD_CONTENT like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("2")) 
			{
				sql.append("select count(*) from MEMBER_BOARD ");
				sql.append("where BOARD_SUBJECT like ? or BOARD_CONTENT like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				pstmt.setString(2, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}
			else if(opt.equals("3")) 
			{
				sql.append("select count(*) from MEMBER_BOARD where BOARD_ID like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}
			
			rs = pstmt.executeQuery();
			if(rs.next())	result = rs.getInt(1);
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return result;
	} 
	
	

	public BoardBean getDetail(int boardNum)
	{	
		BoardBean board = null;
		
		try {
			conn = ds.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from MEMBER_BOARD where BOARD_NUM = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new BoardBean();
				board.setBoard_num(boardNum);
				board.setBoard_id(rs.getString("BOARD_ID"));
				board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
				board.setBoard_content(rs.getString("BOARD_CONTENT"));
				board.setBoard_file(rs.getString("BOARD_FILE"));
				board.setBoard_count(rs.getInt("BOARD_COUNT"));
				board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
				board.setBoard_date(rs.getDate("BOARD_DATE"));
				board.setBoard_parent(rs.getInt("BOARD_PARENT"));
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return board;
	} // end getDetail()
	
	// ��ȸ�� ����
	public boolean updateCount(int boardNum)
	{
		boolean result = false;
		
		try {
			conn = ds.getConnection();
			
			// �ڵ� Ŀ���� false�� �Ѵ�.
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("update MEMBER_BOARD set BOARD_COUNT = BOARD_COUNT+1 ");
			sql.append("where BOARD_NUM = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			
			int flag = pstmt.executeUpdate();
			if(flag > 0){
				result = true;
				conn.commit(); // �Ϸ�� Ŀ��
			}	
		} catch (Exception e) {
			try {
				conn.rollback(); // ������ �ѹ�
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return result;
	} // end updateCount
	
	
	// ������ ���ϸ��� �����´�.
	public String getFileName(int boardNum)
	{
		String fileName = null;
		
		try {
			conn = ds.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT BOARD_FILE from MEMBER_BOARD where BOARD_NUM=?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) fileName = rs.getString("BOARD_FILE");
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		close();
		return fileName;
	} // end getFileName
		
	// �Խñ� ����
	public boolean deleteBoard(int boardNum) 
	{
		boolean result = false;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); // �ڵ� Ŀ���� false�� �Ѵ�.

			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM MEMBER_BOARD");
			sql.append(" WHERE BOARD_NUM IN");
			sql.append(" (SELECT BOARD_NUM");
			sql.append(" FROM MEMBER_BOARD");
			sql.append(" START WITH BOARD_NUM = ?");
			sql.append(" CONNECT BY PRIOR BOARD_NUM = BOARD_PARENT) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			
			int flag = pstmt.executeUpdate();
			if(flag > 0){
				result = true;
				conn.commit(); // �Ϸ�� Ŀ��
			}	
			
		} catch (Exception e) {
			try {
				conn.rollback(); // ������ �ѹ�
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}

		close();
		return result;
	} // end deleteBoard
	
	// �� ����
	public boolean updateBoard(BoardBean border) 
	{
		boolean result = false;
		
		try{
			conn = ds.getConnection();
			conn.setAutoCommit(false); // �ڵ� Ŀ���� false�� �Ѵ�.
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE MEMBER_BOARD SET");
			sql.append(" BOARD_SUBJECT=?");
			sql.append(" ,BOARD_CONTENT=?");
			sql.append(" ,BOARD_FILE=?");
			sql.append(" ,BOARD_DATE=SYSDATE ");
			sql.append("WHERE BOARD_NUM=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, border.getBoard_subject());
			pstmt.setString(2, border.getBoard_content());
			pstmt.setString(3, border.getBoard_file());
			pstmt.setInt(4, border.getBoard_num());
			
			int flag = pstmt.executeUpdate();
			if(flag > 0){
				result = true;
				conn.commit(); // �Ϸ�� Ŀ��
			}
			
		} catch (Exception e) {
			try {
				conn.rollback(); // ������ �ѹ�
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}
	
		close();
		return result;
	} // end updateBoard
	
	
	// DB �ڿ�����
	private void close()
	{
		try {
			if ( pstmt != null ){ pstmt.close(); pstmt=null; }
			if ( conn != null ){ conn.close(); conn=null;	}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	} // end close()
	
}
