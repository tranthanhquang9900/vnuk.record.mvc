package vn.edu.vnuk.record.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.vnuk.record.mvc.jdbc.ConnectionFactory;

@SuppressWarnings("serial")
@WebServlet("/test-connection")
public class TestConnection extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		try {
			Connection connection = new ConnectionFactory().getConnection();
			connection.close();
			
			PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Testing connection</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Connection working properly!</h1>");
	        out.println("</body>");
	        out.println("</html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
}
