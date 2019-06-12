package org.ss.jdbc.intro;

import java.sql.*;

public class App {
	
	public static void main( String... args ) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/digi-jdbc?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String pwd = "";
		Connection connection = DriverManager.getConnection( url, login, pwd );
		Statement st = connection.createStatement();
		st.executeUpdate("Insert into address (details) values ('125 rue de l''ile de Bréhat - 44000 St Herblain')", Statement.RETURN_GENERATED_KEYS);
		ResultSet rs= st.getGeneratedKeys();
		if (rs.next()) {
			st.executeUpdate("INSERT INTO contact (email, first_name, last_name, address_id) VALUES ('tedsdzfst@545','Name','LName', "+ rs.getLong(1)+" )");
		}
		rs.close();

		ResultSet rsSelect =  st.executeQuery("Select * FROM contact c inner join address a on c.address_id = a.id");
		while (rsSelect.next()){
			System.out.println(rsSelect.getString("email")+" " + rsSelect.getString("first_name")+" " + rsSelect.getString("last_name")+" " + rsSelect.getString("details"));
		}

		st.close();

		connection.close();
		
	}
}
