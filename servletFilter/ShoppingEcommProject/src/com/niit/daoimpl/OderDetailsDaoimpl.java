
package com.niit.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.niit.dao.OrderDetailsDao;
import com.niit.domain.Orderdetails;
import com.niit.util.JdbcUtil;

public class OderDetailsDaoimpl implements OrderDetailsDao{
    JdbcUtil util=new JdbcUtil();
    
    @Override
    public void save(Orderdetails orderdetails) {
        try {
            String sql="insert into orderdetails(oid,pid,cid,price,quantity) values(?,?,?,?,?)";
            PreparedStatement pst = util.createPST(sql);
            pst.setInt(1, orderdetails.getOid());
            pst.setInt(2, orderdetails.getPid());
            pst.setInt(3, orderdetails.getCid());
            pst.setDouble(4, orderdetails.getPrice());
            pst.setInt(5, orderdetails.getQuantity());
            pst.executeUpdate();
            
            pst.close();
        } catch (SQLException ex) {
ex.printStackTrace();        }
    
    
    
    }
    
}
