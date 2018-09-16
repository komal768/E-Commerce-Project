package com.niit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentRegServlet
 */
@WebServlet("/stdreg")
public class StudentRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		int marks=Integer.parseInt(req.getParameter("marks"));  
		out.println("Name="+name);
		out.println("Email="+email);
		out.println("Marks="+marks);
		
		
		super.doGet(req, resp);
	}
	
	
	
	
	}


