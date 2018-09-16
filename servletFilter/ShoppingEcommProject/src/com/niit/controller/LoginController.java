
package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.service.LoginAuthenticate;


@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String email=request.getParameter("email");
           String password=request.getParameter("password");
            LoginAuthenticate lu=new LoginAuthenticate();
            boolean validate = lu.validate(email, password);
           if(validate){
               HttpSession session = request.getSession();
               session.setAttribute("user", email);
               request.getRequestDispatcher("home.jsp").forward(request, response);
               
               
           }
           else{
               request.setAttribute("error", "Invalid Credentials");
                              request.getRequestDispatcher("login.jsp").forward(request, response);
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}

