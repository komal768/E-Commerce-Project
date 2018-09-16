/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niit.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.util.JdbcUtil;

/**
 *
 * @author Mohammed Shahrukh
 */
public class LoginAuthenticate {
    JdbcUtil jd=new JdbcUtil();
    public boolean validate(String email,String password) throws SQLException{
        String sql="select * from user where email=? and password=?";
        PreparedStatement pst = jd.createPST(sql);
        pst.setString(1, email);
        pst.setString(2, password);
        
        ResultSet rs=pst.executeQuery();
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
    }
}
