package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Action 진입");
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		MemberBean member = new MemberBean();
		
		boolean result = false;
		member.setMB_ID(request.getParameter("mb_id"));
		member.setMB_PW(request.getParameter("mb_pw"));
		System.out.println(request.getParameter("mb_id"));
		System.out.println(request.getParameter("mb_pw"));
		System.out.println("로그인 시도");
		result = memberdao.LoginChk(member);
		
		String msg = "";
		
		if(result == true){			
			msg = member.getMB_ID()+"님이 시군요 반갑습니다.";
			System.out.println("로그인 성공");
			session.setAttribute("id", member.getMB_ID());
		}else{
			msg = "이런..! 고객님이 입력하신 정보와 일치하는 계정을 찾을 수 없었어요. :(";
			System.out.println("로그인 실패");
		}
		request.setAttribute("msg", msg);
		request.setAttribute("result", result);
		return forward;
	}

}
