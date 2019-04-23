package vn.edu.vnuk.record.mvc.action.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.record.mvc.action.Action;
import vn.edu.vnuk.record.mvc.dao.ContactDao;
import vn.edu.vnuk.record.mvc.model.Contact;

public class Delete implements Action{

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idInStringFormat = request.getParameter("id");
		Long id = Long.parseLong(idInStringFormat);
		Contact myContact = new ContactDao().read(id);
		ContactDao contactDao = new ContactDao();
		contactDao.delete(myContact);
		request.setAttribute("myContacts",new ContactDao().read());
		return "/WEB-INF/jsp/contact/index.jsp";
	}
}
