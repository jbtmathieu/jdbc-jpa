package org.ss.jdbc.dao.dal;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PersistenceManager {
    //members

    private static final String URL = "jdbc:mysql://localhost:3306/digi-jdbc?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PWD = "";
    private static final int CHECK_CONNECTION_TIMEOUT= 10;
    private static Connection connection;


    //constr
    private PersistenceManager(){

    }
    //set get

    public static Connection getConnection() throws SQLException {
        if (null == connection
                || connection.isClosed()
                || !connection.isValid(CHECK_CONNECTION_TIMEOUT) ) {

            Properties props = new Properties();
            try (FileInputStream fis = new FileInputStream("resources/conf.properties")) {
                props.load(fis);

            } catch (IOException e) { // e|e  //FilenotfoundExecption extends IOException
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            String url = props.getProperty("ds.jdbc.url");
            String login = props.getProperty("ds.user.login");
            String pwd = props.getProperty("ds.user.pwd");
            connection = DriverManager.getConnection(url, login, pwd);
        }
        return connection;
    }



    //other

    public static void closeConnection() throws SQLException {
        if ( null != connection && !connection.isClosed()){
            connection.close();
        }

    }



}
