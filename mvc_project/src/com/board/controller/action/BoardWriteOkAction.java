package com.board.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.dao.BoardDAO;
import com.main.dto.BoardVO;
import com.main.dto.MemberVO;

public class BoardWriteOkAction implements BoardAction {

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
		HttpSession session = request.getSession();
		MemberVO ss_adminVO = (MemberVO)session.getAttribute("ss_adminVO");
		MemberVO ss_mVo = (MemberVO)session.getAttribute("ss_mVo");
		
		if( ss_adminVO != null ){
			bVo.setBo_pass(ss_adminVO.getMb_pass());
			bVo.setBo_writer(ss_adminVO.getMb_name());
		}
		if( ss_mVo != null ){
			bVo.setBo_pass(ss_mVo.getMb_pass());
			bVo.setBo_writer(ss_mVo.getMb_name());
		}
		
		//설정
		BoardDAO bDao = BoardDAO.getInstance();		
		System.out.println(bVo.toString());
		
		if( command.equals("write") || command.equals("reply")){
			int bo_step = bDao.getBoardReplyStep(bVo);
			bVo.setBo_step(bo_step+1);
			int result = bDao.insertBoard(bVo);
			
			if(result != 1){
				request.setAttribute("message", "입력오류");
				String url = "/adm/skin/basic/write.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('입력성공');");
				out.println("location.href='list.do?bo_table="+bo_table+"';");
				out.println("</script>");
				out.close();
			}
		}
	
		//수정
		if( command.equals("update") ){
			bVo.setBo_idx(Integer.parseInt(bo_idx));
			int result = bDao.updateBoard(bVo);
			
			if(result != 1){
				request.setAttribute("message", "입력오류");
				String url = "/adm/skin/basic/write.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정성공');");
				out.println("location.href='list.do?bo_table="+bo_table+"';");
				out.println("</script>");
				out.close();
			}			
			
		}
		
	}

}
