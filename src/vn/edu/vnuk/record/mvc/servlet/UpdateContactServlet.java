package vn.edu.vnuk.record.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.record.mvc.action.contact.Update;
import vn.edu.vnuk.record.mvc.dao.ContactDao;
import vn.edu.vnuk.record.mvc.model.Contact;

@SuppressWarnings("serial")
@WebServlet("/updateContact")
public class UpdateContactServlet extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		request.setCharacterEncoding ("UTF-8");
	    response.setCharacterEncoding ("UTF-8");
	    response.setContentType ("text / html; charset = UTF-8");
	    
		
		//	seeking writer
		PrintWriter out = response.getWriter();
		
		
		//	finding parameters in the request form
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String dateInStringFormat = request.getParameter("date_of_birth");
		
		Calendar dateOfBirth = null;
		
		// 	converting string to data
		
		
		//	building an Contact object
		
		Contact myContact = null ;
		ContactDao contactDao = new ContactDao();
		Long id = Update.id;
		
		
		try {
			myContact = new ContactDao().read(id);
			if (name!="") {
				myContact.setName(name);
			}
			
			if (address!="") {
				myContact.setAddress(address);
			}
			
			if (email!="") {
				myContact.setEmail(email);
			}
			
			if (dateInStringFormat!="") {
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInStringFormat);
					dateOfBirth = Calendar.getInstance();
					dateOfBirth.setTime(date);
				} 
				
				catch (ParseException e) {
					out.println("Error while converting date");
					return;
				}
				myContact.setDateOfBirth(dateOfBirth);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		// 	save contact in DB
		
		try {
			contactDao.update(myContact);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 	display name of the new contact
		
		try {
			request.setAttribute("myContacts",new ContactDao().read());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher requesDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contact/index.jsp");
		requesDispatcher.forward(request,response);
		
	}
	
}
