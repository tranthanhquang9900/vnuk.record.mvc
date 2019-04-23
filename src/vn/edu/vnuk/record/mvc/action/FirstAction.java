package vn.edu.vnuk.record.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstAction implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Running action and redirecting..");
		return "first-action.jsp";
	}

}
