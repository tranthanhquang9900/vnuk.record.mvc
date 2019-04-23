package vn.edu.vnuk.record.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.record.mvc.action.Action;

@WebServlet("/mvc")
@SuppressWarnings("serial")

public class ControllerServlet extends HttpServlet{
	@SuppressWarnings("rawtypes")
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		String parameter = request.getParameter("action");
		String className = (String.format("vn.edu.vnuk.record.mvc.action.%s",parameter));
		
		try {
			Class myClass = Class.forName(className);
			@SuppressWarnings("deprecation")
			Action action = (Action)myClass.newInstance();
			String page = action.run(request,response);
			request.getRequestDispatcher(page).forward(request,response);	
		}
		catch (Exception e) {
			throw new ServletException("Something went wrong with the Action", e);
		}
		
	}
}
