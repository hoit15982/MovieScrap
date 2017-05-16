package jsp.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;

/**
 * ȭ�� ��ȯ�� ó���ϴ� Action
 *
 */
public class BoardFormChangeAction implements Action
{
	
	private String path;
	

	public void setCommand(String command){
		int idx = command.indexOf(".");
		System.out.println(command);
		path = command.substring(0, idx)+".jsp";
		
		System.out.println(path);
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setNextPath("/board/"+path);
	
		return forward;
	}
}
