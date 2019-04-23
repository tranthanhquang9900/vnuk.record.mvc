package vn.edu.vnuk.record.mvc.action.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.record.mvc.action.Action;
import vn.edu.vnuk.record.mvc.dao.ContactDao;

public class Update implements Action{

	public static Long id;
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idInStringFormat = request.getParameter("id");
		id = Long.parseLong(idInStringFormat);
		request.setAttribute("myContact",new ContactDao().read(id));
		return "/WEB-INF/jsp/contact/update.jsp";
	}
}
