package com.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.controller.action.Action;
import com.main.dao.MemberDAO;
import com.main.dto.MemberVO;
public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/login/memberCheckPass.jsp";
		String mb_pass = request.getParameter("mb_pass") == null ? "" : request.getParameter("mb_pass");
		String mb_id = request.getParameter("mb_id") == null ? "" : request.getParameter("mb_id");
		
		HttpSession session = request.getSession();
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.getMember(mb_id);

		if( mb_pass != null && !mb_pass.equals("") ){
			
			//비밀번호 확인
			int result = mDao.getLogin(mVo.getMb_id(), mb_pass);
			
			if( result > 0 ){
				url = "/login/memberForm.jsp";
				request.setAttribute("is_update", true);
			}else{
				request.setAttribute("message", "비밀번호가 다릅니다.");
			}
			
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
