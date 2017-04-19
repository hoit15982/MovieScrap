package com.board.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.dao.BoardDAO;

public class BoardDeleteAction implements BoardAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO bDao = BoardDAO.getInstance();
		String [] bo_idxs = request.getParameterValues("bo_idx");
		String bo_table = request.getParameter("bo_table");
		
		for( String bo_idx : bo_idxs){
			bDao.deleteBoard(bo_table , Integer.parseInt(bo_idx));
		}
		
		response.setContentType("text/html;charset=utf-8");					
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("location.href='list.do?bo_table="+ bo_table +"';");
		out.println("</script>");
		out.close();
	}

}
