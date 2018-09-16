package com.niit.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
    public static Connection con;
 
    static
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stylestore","root","mysql");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
    public PreparedStatement createPST(String sql) throws SQLException{
        PreparedStatement pst = con.prepareStatement(sql);
    return pst;
    }
    
    public void update(PreparedStatement pst){
    
        try {
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    public ResultSet select(PreparedStatement pst) throws SQLException{
    
        ResultSet rs = pst.executeQuery();
    return rs;
    }  
}