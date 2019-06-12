package org.ss.jdbc.metadata;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String... args) throws SQLException {


        String url = "jdbc:mysql://localhost:3306/digi-jdbc?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String pwd = "";
        Connection connection = DriverManager.getConnection(url, login, pwd);

        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(connection.getCatalog(),null,"", null);
        System.out.println("liste des tables de la base de données : ");
        while (rs.next()){
            System.out.print(rs.getString("TABLE_NAME")+ " - ");

        }
        System.out.println();
        String response;
        Statement st = connection.createStatement();
        do {
            System.out.println("Entrez le nom de la table :");
            response = sc.nextLine();
            //response = "contact";
            if (!response.equalsIgnoreCase("exit")) {

                ResultSet resultSet = st.executeQuery("SELECT * FROM " + response);
                ResultSetMetaData rsMetadata = resultSet.getMetaData();
                int count = rsMetadata.getColumnCount();
                if (count > 0) {
                    System.out.println("Voici les information de la table " + response);
                    for (int i = 1; i <= count; ++i) {
                        System.out.printf("%-15s", rsMetadata.getColumnName(i) + "[" + rsMetadata.getColumnTypeName(i) + "]"); // au minimum 25 caractères - printf = formaté
                    }

                    System.out.println();
                    System.out.println("######################################################################################");
                    while (resultSet.next()) {
                        for (int i = 1; i <= count; ++i) {
                            System.out.printf("%-20s", resultSet.getString(i));
                        }
                        System.out.println();
                    }
                }
                resultSet.close();
            }
        } while (!response.equalsIgnoreCase("exit"));

        st.close();
        rs.close();


        connection.close();
    }
}
