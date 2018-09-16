
package com.niit.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.UserDao;
import com.niit.daoimpl.UserDaoImpl;
import com.niit.domain.User;

@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            
        String userName=request.getParameter("un");
        String password=request.getParameter("pass");
        String fullName=request.getParameter("fn");
        String phone=request.getParameter("ph");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        
        User u=new User();
        u.setUserName(userName);
        u.setPassword(password);
        u.setFullName(fullName);
        u.setPhone(phone);
        u.setEmail(email);
        u.setAddress(address);
            UserDao dao=new UserDaoImpl();
            dao.save(u);
            request.setAttribute("success", "You have registered successfully...");
request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("register.jsp").forward(request, response);
       }
    }

   
}
