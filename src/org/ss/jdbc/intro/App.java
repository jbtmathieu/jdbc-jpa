package org.ss.jdbc.intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	
	public static void main( String... args ) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/digi-jdbc?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String pwd = "";
		Connection connection = DriverManager.getConnection( url, login, pwd );
		Statement st = connection.createStatement();

		connection.close();
		
	}
}
