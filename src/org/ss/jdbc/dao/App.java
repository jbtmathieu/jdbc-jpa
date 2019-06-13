package org.ss.jdbc.dao;

import org.ss.jdbc.dao.dal.PersistenceManager;

import java.sql.*;

public class App {

    public static void main(String[] args) {
/*
        String url = "jdbc:mysql://localhost:3306/digi-jdbc?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String pwd = "";
        Connection connection;

    /*
        try {
            connection = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/

        // depuis java 7
        /*
        try (Connection cnx = DriverManager.getConnection(url, login, pwd);
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM contact")) {

            while (rs.next()) {


            }
        } catch (SQLException e) {

        }

        */


        try (Connection cnx = PersistenceManager.getConnection(); // persistenceM
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM contact")) {

            while (rs.next()) {
                System.out.println(rs.getString("id")+" "+
                        rs.getString("first_name")+" "+
                        rs.getString("last_name"));

            }
        } catch (SQLException e) {
            System.out.println("Attention : " + e.getMessage());
        }

    }

}
