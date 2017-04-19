package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.dao.BoardDAO;
import com.main.dao.BoardOptionDao;
import com.main.dto.BoardOptionVO;
import com.main.dto.BoardVO;
import com.main.dto.MemberVO;

public class BoardWriteAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bo_table = request.getParameter("bo_table");
		String bo_idx = request.getParameter("bo_idx");
		
		//bo_table 로 게시판 정보 불러오기.
		BoardOptionDao optionDao = BoardOptionDao.getInstance();
		BoardOptionVO optionVo = optionDao.getBoardOption(bo_table);
		request.setAttribute("optionVo", optionVo);

		//수정
		if( bo_idx != null){

			BoardDAO bDao = BoardDAO.getInstance();
			BoardVO bVo = bDao.getBoard(optionVo.getOp_table() , Integer.parseInt(bo_idx)); //해당 bo_idx로 게시물 정보 가져오기.
			
			//해당 bo_idx로 게시물 정보 넣기
			request.setAttribute("bVo", bVo);
			request.setAttribute("update", true);
			
			//관리자 정보
			HttpSession session = request.getSession();
			MemberVO adminVo = (MemberVO)session.getAttribute("ss_adminVO");
			request.setAttribute("adminVo", adminVo); 
			
			//회원정보
			MemberVO mVo = (MemberVO)session.getAttribute("ss_adminVO");
			request.setAttribute("mVo", mVo);
			
		}

		String url = "/adm/skin/"+optionVo.getOp_adm_skin()+"/write.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);				
	
	}

}
