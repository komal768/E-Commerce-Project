
package com.niit.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.niit.dao.OrderDao;
import com.niit.domain.Order;


public class OrderDaoImpl implements OrderDao{
//JdbcUtil jd=new JdbcUtil();
    @Override
    public int save(Order o) {
        String sql="insert into orders(name,date,custName,custAddress,email,city) values(?,?,?,?,?,?)";
 try {
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stylestore?user=root&password=mysql");
            PreparedStatement pst = con.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
     //PreparedStatement pst = jd.createPST(sql);
            pst.setString(1, o.getName());
            pst.setString(2, o.getOrderDate());
            pst.setString(3, o.getCustomerName());
            pst.setString(4, o.getCustomerAddress());
            pst.setString(5, o.getEmail());
            pst.setString(6, o.getCity());
        pst.executeUpdate();
       ResultSet rs = pst.getGeneratedKeys();
           int generatedkey=0;

    if(rs.next()) {
      generatedkey=rs.getInt(1); 
      //what you get is only a RowId ref, try make use of it anyway U could think of
      System.out.println(generatedkey+"yyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }
        pst.close();
        return generatedkey;
    }catch(Exception e){
        e.printStackTrace();
        return 0;
    }}
    
}
