package vn.edu.vnuk.record.mvc.action.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.record.mvc.action.Action;
import vn.edu.vnuk.record.mvc.dao.ContactDao;

public class Index implements Action{

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("myContacts",new ContactDao().read());
		return "/WEB-INF/jsp/contact/index.jsp";
	}
}
