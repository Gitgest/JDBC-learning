/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rasmus laptop
 */
public class JDBCLearning {


    private static final String USERNAME = "dbuser";
    private static final String PSSWRD = "dbpassword";
    private static final String CONN_STRING = 
             "jdbc:mysql://localhost/explorecalifornia";
    
    public static void main(String[] args) throws SQLException {
     //Class.forName("com.mysql.jdbc.Driver");
     
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PSSWRD);
            System.out.println("Connected!");
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            if(conn!=null){
                conn.close();
            }
        }
    }
    
}

