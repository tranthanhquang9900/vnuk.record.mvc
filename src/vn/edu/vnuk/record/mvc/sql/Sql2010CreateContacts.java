package vn.edu.vnuk.record.mvc.sql;

import java.sql.Connection;
import java.sql.SQLException;

public class Sql2010CreateContacts {
	private final Connection connection;
	private final String sqlQuery;
	
	public Sql2010CreateContacts(Connection connection) {
		this.connection = connection;
		
		this.sqlQuery = "CREATE TABLE IF NOT EXISTS contacts ("
				+ 	"id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
				+ 	"name VARCHAR(255) NOT NULL, "
				+ 	"email VARCHAR(255) NOT NULL, "
				+ 	"address VARCHAR(255) NOT NULL, "
				+ 	"date_of_birth DATE NOT NULL"
				+ ") CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"
			;
	}
	
	public void run() throws SQLException {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(">  Sql2010CreateContacts started");
		
		try {
	        connection.prepareStatement(sqlQuery).execute();
	        System.out.println("   TABLE \'contacts\' successfully created");
		
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
			System.out.println("<  Sql2010CreateContacts ended");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
		}
			
	}
}
