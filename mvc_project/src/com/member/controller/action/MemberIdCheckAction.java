package com.member.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.controller.action.Action;
import com.main.dao.MemberDAO;
import com.main.dto.MemberVO;
public class MemberIdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String mb_id = request.getParameter("mb_id");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.getMember(mb_id);
		
		if( mVo != null ){
			out.println("true");
		}else{
			out.println("false");
		}
		
		out.close();
	}
}
