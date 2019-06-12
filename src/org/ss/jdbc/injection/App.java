package org.ss.jdbc.injection;

import java.sql.*;
import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void main( String... args ) throws SQLException {


        String url = "jdbc:mysql://localhost:3306/digi-jdbc?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String pwd = "";
        Connection connection = DriverManager.getConnection( url, login, pwd );
        Statement st = connection.createStatement();

        System.out.println("##### Boite de Login #####");
        System.out.println("Entre votre login : ");
        String loginUser = sc.nextLine();
        System.out.println("Entre votre login : ");
        String password= sc.nextLine();

        ResultSet rs = st.executeQuery("select * from contact WHERE email = '"+loginUser+"' AND first_name = '"+ password + "'" );

        if (rs.next()){
            System.out.println(rs.getString("email")+" " + rs.getString("first_name")+" " + rs.getString("last_name"));
        } else {
            System.out.println("Erreur : login / mot de passe ");
        }

        rs.close();


        st.close();

        connection.close();

    }
}
