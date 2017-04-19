package com.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.dao.BoardDAO;
import com.main.dao.BoardOptionDao;
import com.main.dto.BoardOptionVO;
import com.main.dto.BoardVO;

public class BoardViewAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//bo_idx, bo_table를  request 파라미터로 값을 받는다.
		String bo_table = request.getParameter("bo_table");
		String bo_idx = request.getParameter("bo_idx");
		
		//board 옵션 값을 가지고 온다.
		BoardOptionDao optionDao = BoardOptionDao.getInstance();
		BoardOptionVO optionVo = optionDao.getBoardOption(bo_table);
		
		//옵션값에 해당하는 스킨으로 설정.
		String url = "/adm/skin/"+optionVo.getOp_adm_skin()+"/view.jsp";
		
		if( optionVo != null && bo_idx != null){
			
			//스킨설정
			url = "/adm/skin/"+optionVo.getOp_adm_skin()+"/view.jsp";
			
			//게시판 정보설정
			request.setAttribute("optionVo", optionVo); 
			
			BoardDAO bDao = BoardDAO.getInstance();
			BoardVO bVo = bDao.getBoard(optionVo.getOp_table(), Integer.parseInt(bo_idx)); 
			
			//게시물 정보설정
			request.setAttribute("bVo", bVo); 

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
