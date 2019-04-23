package vn.edu.vnuk.record.mvc.action.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.record.mvc.action.Action;

public class Create implements Action{

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/WEB-INF/jsp/contact/create.jsp";
	}
}
