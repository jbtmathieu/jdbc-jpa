package org.ss.jdbc.dao;

import org.ss.jdbc.dao.dal.DBConnection;
import org.ss.jdbc.dao.dal.PersistenceManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App3 {
    public static void main(String[] args) {

        try {
            DBConnection db = DBConnection.getSingle();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
