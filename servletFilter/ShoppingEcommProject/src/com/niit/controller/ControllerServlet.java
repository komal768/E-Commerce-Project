/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.dao.CategoryDao;
import com.niit.dao.OrderDao;
import com.niit.dao.OrderDetailsDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.daoimpl.CategoryDaoImpl;
import com.niit.daoimpl.OderDetailsDaoimpl;
import com.niit.daoimpl.OrderDaoImpl;
import com.niit.daoimpl.ProductDaoIMpl;
import com.niit.daoimpl.UserDaoImpl;
import com.niit.domain.Category;
import com.niit.domain.Item;
import com.niit.domain.Order;
import com.niit.domain.Orderdetails;
import com.niit.domain.Product;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/home", "/logins", "/registers", "/get", "/getProduct", "/orderNow", "/showCart", "/cartClear", "/deleteCartP","/qUpdate", "/checkout", "/saveOrder"})
public class ControllerServlet extends HttpServlet {

    UserDao udao = new UserDaoImpl();
    CategoryDao cdao = new CategoryDaoImpl();
    ProductDao pdao = new ProductDaoIMpl();
    OrderDao odao = new OrderDaoImpl();
    OrderDetailsDao oddao = new OderDetailsDaoimpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();

        /* List<Category> clist = cdao.list();
                System.out.println(clist.size()+"--------------");
                request.setAttribute("clist",clist);
                
                for (Category c: clist) {
                System.out.println(c.getId()+"  "+c.getName());
                }*/
        try (PrintWriter out = response.getWriter()) {
            if (userPath.equals("/home")) {

                List<Category> clist = cdao.listByName("men");
                List<Category> clist2 = cdao.listByName("women");
                // System.out.println(clist2.size()+"------womennnnnn--------");
                //request.setAttribute("list",clist);
                ServletContext servletContext = getServletContext();
                servletContext.setAttribute("list", clist);
                servletContext.setAttribute("list2", clist2);

                request.getRequestDispatcher("home.jsp").forward(request, response);

            } else if (userPath.equals("/get")) {
                List<Product> plist = pdao.byCategory(Integer.parseInt(request.getParameter("id")));
                System.out.println("working....." + request.getParameter("id"));
                ServletContext application = getServletContext();
                application.setAttribute("plist", plist);
                request.getRequestDispatcher("productlist.jsp").forward(request, response);
                System.out.println("size..........." + plist.size());
            } else if (userPath.equals("/getProduct")) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Product p = pdao.get(pid);
                ServletContext application = getServletContext();
                application.setAttribute("p", p);
                request.getRequestDispatcher("pdetails.jsp").forward(request, response);

            } else if (userPath.equals("/orderNow")) {

                int pid = Integer.parseInt(request.getParameter("pid"));
                if (session.getAttribute("newCart") == null) {
                    List<Item> cart = new ArrayList<Item>();
                    Product p = pdao.get(pid);
                    if (p.getId() == pid) {
                        cart.add(new Item(p, 1));
                    }
                    session.setAttribute("newCart", cart);
                    request.getRequestDispatcher("/getProduct").forward(request, response);
                } else {
                    List<Item> cart = (List<Item>) session.getAttribute("newCart");
                    Product p = null;
                    int index = isExisting(pid, session);
                    if (index == -1) {
                        p = pdao.get(pid);
                        if (p.getId() == pid) {
                            cart.add(new Item(p, 1));
                        }
                    } else {
                        int quantity = cart.get(index).getQuantity() + 1;
                        cart.get(index).setQuantity(quantity);

                    }
                    session.setAttribute("newCart", cart);
                    request.getRequestDispatcher("/getProduct").forward(request, response);

                }

            } else if (userPath.equals("/showCart")) {
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            } else if (userPath.equals("/cartClear")) {
                List<Item> cart = (List<Item>) session.getAttribute("newCart");
                if(cart!=null){
                cart.clear();}
                String contextPath = request.getContextPath();
                //response.sendRedirect(contextPath + "/showCart");
request.getRequestDispatcher("cart.jsp").forward(request, response);
            } 
            
            else if (userPath.equals("/deleteCartP")) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                List<Item> cart = (List<Item>) session.getAttribute("newCart");
                int index = isExisting(pid, session);
                cart.remove(index);
                response.sendRedirect(request.getContextPath() + "/showCart");
            } 
            
            
            else if (userPath.equals("/checkout")) {
            List<Item> cart = (List<Item>) session.getAttribute("newCart");
            if (cart==null) {
            // mav.addObject("errors", "No product in the Cart");
            request.setAttribute("emptyCart", "No poduct in the cart");
            request.getRequestDispatcher("cart.jsp").forward(request, response);
            
            } else {
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
            
            }
            
            }
            /*else if (userPath.equals("/saveOrder")) {
            List<Item> cart = (List<Item>) session.getAttribute("newCart");
            String customerName = request.getParameter("customerName");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String customerAddress = request.getParameter("customerAddress");
            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            Order o = new Order();
            o.setCustomerName(customerName);
            o.setEmail(email);
            o.setName(name);
            o.setCustomerAddress(customerAddress);
            o.setCity(city);
            o.setPhone(phone);
            
            try {
            o.setOrderDate(new Date().toString());
            int oid = odao.save(o);
            for (int i = 0; i < cart.size(); i++) {
            Orderdetails orderDetails = new Orderdetails();
            orderDetails.setOid(oid);
            orderDetails.setPid(cart.get(i).getP().getId());
            orderDetails.setPrice(cart.get(i).getP().getPrice());
            orderDetails.setQuantity(cart.get(i).getQuantity());
            String loggedUser = (String) session.getAttribute("user");
            orderDetails.setCid(udao.getUserByName(loggedUser).getUid());
            oddao.save(orderDetails);
            }
            session.removeAttribute("newCart");
            request.getRequestDispatcher("/home").forward(request, response);
            
            } catch (Exception e) {
            e.printStackTrace();
            }
            
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int isExisting(int id, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("newCart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getP().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
      String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        
        
        if (userPath.equals("/checkout")) {
                List<Item> cart = (List<Item>) session.getAttribute("newCart");
                if (cart.isEmpty()) {
                    // mav.addObject("errors", "No product in the Cart");
                    request.setAttribute("emptyCart", "No poduct in the cart");
                    request.getRequestDispatcher("/showCart").forward(request, resp);

                } else {
                    request.getRequestDispatcher("checkout.jsp").forward(request, resp);

                }
            } else if (userPath.equals("/saveOrder")) {
                List<Item> cart = (List<Item>) session.getAttribute("newCart");
                String customerName = request.getParameter("customerName");
                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String customerAddress = request.getParameter("customerAddress");
                String city = request.getParameter("city");
                String phone = request.getParameter("phone");
                Order o = new Order();
                o.setCustomerName(customerName);
                o.setEmail(email);
                o.setName(name);
                o.setCustomerAddress(customerAddress);
                o.setCity(city);
                o.setPhone(phone);

                try {
                    o.setOrderDate(new Date().toString());
                    int oid = odao.save(o);
                    for (int i = 0; i < cart.size(); i++) {
                        Orderdetails orderDetails = new Orderdetails();
                        orderDetails.setOid(oid);
                        orderDetails.setPid(cart.get(i).getP().getId());
                        orderDetails.setPrice(cart.get(i).getP().getPrice());
                        orderDetails.setQuantity(cart.get(i).getQuantity());
                        String loggedUser = (String) session.getAttribute("user");
                        orderDetails.setCid(udao.getUserByName(loggedUser).getUid());
                        oddao.save(orderDetails);
                    }
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
 session.removeAttribute("newCart");
 request.getRequestDispatcher("acknowledgement.jsp").forward(request, resp);

            }
        else if (userPath.equals("/qUpdate"))
        {
      List<Item> cart = (List<Item>) session.getAttribute("newCart");

                String[] quantity = request.getParameterValues("quantity");
for (int i = 0; i < cart.size(); i++) {
            cart.get(i).setQuantity(Integer.parseInt(quantity[i]));
        }
        session.setAttribute("newCart", cart);
request.getRequestDispatcher("cart.jsp").forward(request, resp);
        }

        
 }

    
}
