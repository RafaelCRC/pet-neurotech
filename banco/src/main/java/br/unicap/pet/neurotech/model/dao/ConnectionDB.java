package br.unicap.pet.neurotech.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.unicap.pet.neurotech.model.exceptions.ValorInvalidoException;

public class ConnectionDB {

    private static String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10439832";
    private static String user = "sql10439832";
    private static String password = "zAzLrhmaiF";

    public static Connection connect(){

        try {

            Connection con = DriverManager.getConnection(url, user, password);

            return con;
        } catch (SQLException e) {
            System.out.println("erro conexao");
            e.printStackTrace();
            return null;
        }

    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
