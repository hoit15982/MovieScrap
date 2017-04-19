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
import com.main.dto.BoardVO;

public class BoardFrontCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bo_pass = request.getParameter("bo_pass");
		String bo_idx = request.getParameter("bo_idx");
		String bo_table = request.getParameter("bo_table");
		String command = request.getParameter("command");
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.getBoard(bo_table, Integer.parseInt(bo_idx));
		
		request.setAttribute("bVo", bVo);
		
		if( bo_pass == null ){
			request.setAttribute("message", "비밀번호를 입력해주세요");
		}else{

			int reslut = bDao.chkBoardPass(bo_table, Integer.parseInt(bo_idx), bo_pass);
			if( reslut == 1 ){
				request.setAttribute("message", "성공");
				//수정인경우
				if( command.equals("update") ){
					response.sendRedirect("write.do?bo_table="+ bo_table +"&bo_idx="+bo_idx);
					return;
				}
				//삭제인경우
				if( command.equals("delete") ){
					new BoardFrontDeleteAction().execute(request, response);
				}
				//비밀글인경우
				if( command.equals("secret") ){
					
					HttpSession session = request.getSession();
					
					// 세션에 아래 정보를 저장.
					session.setAttribute("ss_secret_"+bo_table+"_"+bo_idx, true);
					response.sendRedirect("view.do?bo_table="+bo_table+"&bo_idx="+bo_idx);
					
					return;
				}
			}else{
				request.setAttribute("message", "비밀번호가 다릅니다.");
			}
		}
		
		String url = "/bbs/boardCheckPass.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
