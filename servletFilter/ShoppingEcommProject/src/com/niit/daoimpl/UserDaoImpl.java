
package com.niit.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.niit.dao.UserDao;
import com.niit.domain.User;
import com.niit.util.JdbcUtil;

public class UserDaoImpl implements UserDao{
//working on this
    JdbcUtil util=new JdbcUtil();
    
    @Override
    public void save(User u) {
        String sql="insert into user(userName,password,fullName,phone,email,address) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = util.createPST(sql);
            pst.setString(1, u.getUserName());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getFullName());
            pst.setString(4, u.getPhone());
            pst.setString(5, u.getEmail());
            pst.setString(6, u.getAddress());
            pst.executeUpdate();
            
            pst.close();
            
        } catch (SQLException ex) {
ex.printStackTrace();       
        
        }
        
        
    }

    @Override
    public void delete(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public User getUserByName(String email){
        String sql="select * from user where email=?";
        User u=null;
       try{
        PreparedStatement pst = util.createPST(sql);
        pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               u=new User();
              u.setUid(rs.getInt("uid"));
              u.setFullName(rs.getString("fullName"));
            return u;
            }
       }catch(Exception e){
       e.printStackTrace();
           return null;
       
       
       }
        return u;
        
    }
    
}
