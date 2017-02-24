/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rasmus laptop
 */
public class JDBCLearning {

//test
    private static final String USERNAME = "dbuser";
    private static final String PSSWRD = "dbpassword";
    private static final String CONN_STRING
            = "jdbc:mysql://localhost/explorecalifornia";

    public static void main(String[] args) throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PSSWRD);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM states");

            rs.last();
            System.out.println("Number of rows: " + rs.getRow());

            //    System.out.println("Connected!");
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            if (rs != null) {
                conn.close();
            }
            if (stmt != null) {
                conn.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
