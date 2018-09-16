package com.niit.domain;
import java.util.Date;

public class Order  {


     private int orderId;
     private String name;
  
     private String orderDate;
     private String customerName;
     private String customerAddress;
     private String email;
    private String phone;
    private String city;
    public Order() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	
    public Order(int orderId) {
        this.orderId = orderId;
    }
    public Order(int orderId, String name, String orderDate, String customerName, String customerAddress) {
       this.orderId = orderId;
       this.name = name;
       this.orderDate = orderDate;
       this.customerName = customerName;
       this.customerAddress = customerAddress;
       
    }
   
    
    public int getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    
   
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

  
    

    
  
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    
    public String getCustomerAddress() {
        return this.customerAddress;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


   



}


