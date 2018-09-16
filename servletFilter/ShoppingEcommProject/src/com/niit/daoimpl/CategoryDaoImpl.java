
package com.niit.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.dao.CategoryDao;
import com.niit.domain.Category;
import com.niit.util.JdbcUtil;

public class CategoryDaoImpl implements CategoryDao{
    JdbcUtil jd=new JdbcUtil();
    @Override
    public void save(Category u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Category u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> list() {
        String sql="select * from category";
        List<Category> clist=new ArrayList<>();
        try {
            PreparedStatement pst = jd.createPST(sql);
          //  pst.setString(1, "men");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Category c=new Category();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setDescription(rs.getString(3));
                clist.add(c);
            }
                        return clist;

            
        } catch (SQLException ex) {
ex.printStackTrace();
return null;        }
        
        
    }
    
    
   public List<Category> listByName(String name ){
         String sql="select * from category where subc=?";
        List<Category> clist=new ArrayList<>();
        try {
            PreparedStatement pst = jd.createPST(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Category c=new Category();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setDescription(rs.getString(3));
                clist.add(c);
            }
                        return clist;

            
        } catch (SQLException ex) {
ex.printStackTrace();
return null;        }
        
        
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
