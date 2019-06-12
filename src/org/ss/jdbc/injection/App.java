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


        //String query = "select * from contact WHERE email = '"+loginUser+"' AND first_name = '"+ password + "'";
        String query = "select * from contact WHERE email = ? AND first_name = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,loginUser);
        ps.setString(2,password);

        //ResultSet rs = st.executeQuery( query);
        ResultSet rs = ps.executeQuery();
        System.out.println(query);
        System.out.println(ps);

        if (rs.next()){
            System.out.println("Bienvenue dans votre espace de travail : "+" " + rs.getString("first_name")+" " + rs.getString("last_name"));
        } else {
            System.out.println("Erreur : login / mot de passe ");
        }

        rs.close();


        st.close();

        connection.close();

    }
}
