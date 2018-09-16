package com.niit.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.dao.ProductDao;
import com.niit.domain.Product;
import com.niit.util.JdbcUtil;

public class ProductDaoIMpl implements ProductDao{
    JdbcUtil jd=new JdbcUtil();
    @Override
    public void save(Product u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Product u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> byCategory(int id) {
        List<Product> plist=new ArrayList<>();
        try {
            PreparedStatement pst = jd.createPST("select * from product where cid=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setBrand(rs.getString("brand"));
                p.setDescription(rs.getString("description"));
                p.setQuantity((rs.getInt("quantity")));
                p.setPrice((rs.getDouble("price")));
                p.setImg(rs.getString("img"));
                plist.add(p);
                        
            }
                            return plist;

        } catch (SQLException ex) {
ex.printStackTrace();   
return null;
        }
    }

    @Override
    public Product get(int id) {
        String sql="select * from product where id=?";
              Product p=new Product();

        try {
            PreparedStatement pst=jd.createPST(sql);
            pst.setInt(1, id);
           ResultSet rs= pst.executeQuery();
           while(rs.next()){
              
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setBrand(rs.getString("brand"));
                p.setDescription(rs.getString("description"));
                p.setQuantity((rs.getInt("quantity")));
                p.setPrice((rs.getDouble("price")));
                p.setImg(rs.getString("img"));
           }
           return p;
        } catch (SQLException ex) {
         ex.printStackTrace();  
         return null;
        }
    }
    
}
