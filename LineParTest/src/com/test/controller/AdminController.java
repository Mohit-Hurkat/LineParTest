package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bean.Admin;
import com.test.bl.AdminLogic;
import com.test.bl.LoginCheck;
 
 
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("login") != null) {
			
			String user=request.getParameter("userName");
			String pass=request.getParameter("password");
			Admin ad=new Admin(user,pass);
			LoginCheck lc=new LoginCheck();
			try {
				if(lc.check(ad))
				{
					HttpSession session=request.getSession();  
			        session.setAttribute("username",user); 
					RequestDispatcher dispatch=request.getRequestDispatcher("./admin.jsp");
					dispatch.forward(request, response);
				}
				else
				{
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
		} 
		else if(request.getParameter("update") != null)
		{
			HttpSession session=request.getSession(false);  
	        String user=(String)session.getAttribute("username"); 
		     AdminLogic adLogic=new AdminLogic();
		     Admin ad=null;
		     try {
				ad=adLogic.search(user);
				if(ad.getUsername().equals(user))
				{
				String newuser=request.getParameter("userName");
				String newpass=request.getParameter("password");
				ad=new Admin(newuser,newpass);
				request.setAttribute("adminupdate", ad);
				RequestDispatcher dispatch=request.getRequestDispatcher("./admin.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("adminupdate", null);
					RequestDispatcher dispatch=request.getRequestDispatcher("./admin.jsp");
					dispatch.forward(request, response);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
		}
		else if (request.getParameter("search") != null) {
			HttpSession session=request.getSession(false);  
	        String user=(String)session.getAttribute("username");  
		     AdminLogic adLogic=new AdminLogic();
		     try {
				Admin ad=adLogic.search(user);
				request.setAttribute("adminserach", ad);
				RequestDispatcher dispatch=request.getRequestDispatcher("./admin.jsp");
				dispatch.forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
		     
		}

		 
	 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}