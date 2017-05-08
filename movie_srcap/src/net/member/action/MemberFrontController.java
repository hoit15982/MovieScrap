package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		if (command.equals("/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/loginForm.jsp");
			System.out.println("front open");
			System.out.println(action);
			System.out.println(forward);

		} else if (command.equals("/MemberIntro.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/joinIntro.jsp");
			System.out.println("front open");
			System.out.println(action);
			System.out.println(forward);

		} else if (command.equals("/memberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/memberForm.jsp");
			System.out.println("front open");
			System.out.println(action);
			System.out.println(forward);

		} else if (command.equals("/findIdPw.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/findIdPw.jsp");
			System.out.println("front open");
			System.out.println(action);
			System.out.println(forward);

		} else if (command.equals("/joinFin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/joinFin.jsp");
			System.out.println("front open");
			System.out.println(action);
			System.out.println(forward);

		} else if (command.equals("/findIdFin.me")) {
			action = new FindIdAction();
			forward = new ActionForward();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			forward.setRedirect(false);
			forward.setPath("./member/findIdFin.jsp");
		} else if (command.equals("/login.me")) {
			action = new LoginAction();
			forward = new ActionForward();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			forward.setRedirect(false);
			forward.setPath("./main/main.jsp");
		} else if (command.equals("/MemberJoinAction.me")) {
			action = new MemberJoinAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}