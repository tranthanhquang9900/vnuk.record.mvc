package vn.edu.vnuk.record.mvc.sql;

import java.sql.Connection;
import java.sql.SQLException;

public class Sql1010CreateDatabase {
	private final Connection connection;
	private final String sqlQuery;
	
	public Sql1010CreateDatabase(Connection connection) {
		this.connection = connection;
		this.sqlQuery = "CREATE DATABASE IF NOT EXISTS vnuk CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;";
	}
	
	public void run() throws SQLException {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(">  Sql1010CreateDatabase started");
		
		try {
	        connection.prepareStatement(sqlQuery).execute();
	        System.out.println("   DB \'vnuk\' successfully created");
		
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
			System.out.println("<  Sql1010CreateDatabase ended");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
		}
			
	}
}
