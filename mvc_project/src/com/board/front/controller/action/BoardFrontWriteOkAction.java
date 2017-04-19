package com.board.front.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.controller.action.Action;
import com.main.dao.BoardDAO;
import com.main.dao.BoardOptionDao;
import com.main.dao.MemberDAO;
import com.main.dto.BoardOptionVO;
import com.main.dto.BoardVO;
import com.main.dto.MemberVO;

public class BoardFrontWriteOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//파라미터로 필요한 값 가져오기.
		String command = request.getParameter("command"); //입력 수정 선택
		String bo_idx = request.getParameter("bo_idx");
		String bo_table = request.getParameter("bo_table");
		String bo_writer = request.getParameter("bo_writer") == null ? "" : request.getParameter("bo_writer");
		String bo_member = request.getParameter("bo_member") == null ? "" : request.getParameter("bo_member");
		String bo_subject = request.getParameter("bo_subject") == null ? "" : request.getParameter("bo_subject");
		String bo_content = request.getParameter("bo_content") == null ? "" : request.getParameter("bo_content");
		String bo_pass = request.getParameter("bo_pass") == null ? "" : request.getParameter("bo_pass");
		int bo_is_notice = request.getParameter("bo_is_notice") == null ? 0 : Integer.parseInt(request.getParameter("bo_is_notice"));
		int bo_is_view = request.getParameter("bo_is_view") == null ? 0 : Integer.parseInt(request.getParameter("bo_is_view"));
		int bo_is_secret = request.getParameter("bo_is_secret") == null ? 0 : Integer.parseInt(request.getParameter("bo_is_secret"));
		int bo_ref = request.getParameter("bo_ref") == null ? 0 : Integer.parseInt(request.getParameter("bo_ref"));
		int bo_level = request.getParameter("bo_level") == null ? 0 : Integer.parseInt(request.getParameter("bo_level"));
	
		//bo_table 로 게시판 정보 불러오기.
		BoardOptionDao optionDao = BoardOptionDao.getInstance();
		BoardOptionVO optionVo = optionDao.getBoardOption(bo_table);

		//값을 Board DTO에 저장하기
		BoardVO bVo = new BoardVO();
		bVo.setBo_table(bo_table);

		bVo.setBo_writer(bo_writer);
		bVo.setBo_member(bo_member);
		bVo.setBo_subject(bo_subject);
		bVo.setBo_content(bo_content);
		bVo.setBo_pass(bo_pass);
		bVo.setBo_is_notice(bo_is_notice);
		bVo.setBo_is_secret(bo_is_secret);
		bVo.setBo_is_view(bo_is_view);
		bVo.setBo_ref(bo_ref);
		bVo.setBo_level(bo_level);
		
		//회원 , 관리자 정보 ( 로그인 했을 경우 )
		MemberDAO mDao =MemberDAO.getInstance();
		HttpSession session = request.getSession();
		
		if( session.getAttribute("ss_mb_id") != null ){
			String mb_id = (String)session.getAttribute("ss_mb_id");
			MemberVO mVo = mDao.getMember(mb_id);
			
			//회원인경우 bo_writer, bo_member, bo_pass 자동입력
			bVo.setBo_member(mVo.getMb_id());
			bVo.setBo_writer(mVo.getMb_name());
			bVo.setBo_pass(mVo.getMb_pass());
		}
				
		//설정
		BoardDAO bDao = BoardDAO.getInstance();		
		System.out.println(bVo.toString());

		
		if( command.equals("write") || command.equals("reply")){
			int bo_step = bDao.getBoardReplyStep(bVo);
			bVo.setBo_step(bo_step+1);
			int result = bDao.insertBoard(bVo);
			
			if(result != 1){
				//입력실패
				request.setAttribute("message", "입력오류");
				String url = "/skin/"+optionVo.getOp_skin()+"/write.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else{
				//입력완료 리스트로 이동
				response.sendRedirect("list.do?bo_table="+bo_table);
				return;
			}
		}
	
		//수정
		if( command.equals("update") ){
			bVo.setBo_idx(Integer.parseInt(bo_idx));
			int result = bDao.updateBoard(bVo);
			
			if(result != 1){
				request.setAttribute("message", "입력오류");
				String url = "/skin/"+optionVo.getOp_skin()+"/write.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else{
				//수정성공
				response.sendRedirect("view.do?bo_table="+bo_table+"&bo_idx="+bo_idx);
			}
		}

	}

}
