package br.unicap.pet.neurotech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste {
    public static void main(String[] args) {

        String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10439832";
        String user = "sql10439832";
        String password = "zAzLrhmaiF";
        

        int numConta = 1;
        //"INSERT INTO ContaRafael (userLogin, userPassword, accountType, ballance)"+
        //"VALUES(rafael, 123, 1, 1000);";
        String query1 = "INSERT INTO ContaRafael (userLogin, userPassword, accountType, ballance)"+
        "VALUES('rafael', 123, 1, 1000);";

        String query2 = "select * from ContaRafael;";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            //st.execute(query1);
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
                //System.out.println(rs.getString(0));
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            //ResultSet rs = st.executeQuery(query1);
        //    ) {

            // while (rs.next()) {
                
            //     System.out.println(rs.getString(1));
            // }

        // } catch (SQLException ex) {
        //     ex.printStackTrace();
        //     System.out.println("error!");
        // } 
    }
}