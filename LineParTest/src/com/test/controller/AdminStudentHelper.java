package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bean.Student;
import com.test.bl.StudentLogic;


public class AdminStudentHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if (request.getParameter("display") != null) {
			 HttpSession session=request.getSession(false);
				StudentLogic lc=new StudentLogic(); 
				try {
					List<Student> stu=lc.displayAll();
					if(stu!=null)
					{
						System.out.println("enter");
					session.setAttribute("studentDisplay", stu);
					response.sendRedirect("./Admin/AdminStudent/deleteStudent.jsp");
					}
					else
					{
						request.setAttribute("studentDelete","Error.");
						RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
						dispatch.forward(request, response);
					}
				} catch (ClassNotFoundException | SQLException e) {
				 
					e.printStackTrace();
				}
			  
			}
		
	}

}
