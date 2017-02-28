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
 
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		if (request.getParameter("insert") != null) {
		 
			StudentLogic lc=new StudentLogic(); 
			String suname=request.getParameter("suname");
			String spass=request.getParameter("spass");
			String sname=request.getParameter("sname");
			String sphone=request.getParameter("sphone");
			String semail=request.getParameter("semail");
			Student student=new Student(suname, spass, sname, sphone, semail);
			try {
				if(lc.insert(student))
				{
					request.setAttribute("studentinsert","Successfully Inserted.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("studentinsert"," Error.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else if(request.getParameter("delete") != null)
		{
			HttpSession session=request.getSession(false);
			String suname=request.getParameter("username");
			StudentLogic lc=new StudentLogic(); 
			try {
				if(lc.delete(suname))
				{
					session.setAttribute("studentDelete","Successfully Deleted.");
					response.sendRedirect("./Admin/adminStudent.jsp");
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
		else if (request.getParameter("search") != null) {
			String suname=request.getParameter("suname");
			StudentLogic lc=new StudentLogic(); 
			try {
				Student stu=lc.search(suname);
				if(stu.getUsername().equals(suname))
				{
				request.setAttribute("studentsearch", stu);
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
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
		else if (request.getParameter("display") != null) {
			 
			StudentLogic lc=new StudentLogic(); 
			try {
				List<Student> stu=lc.displayAll();
				if(stu!=null)
				{
				request.setAttribute("studentdisplay", stu);
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
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
		else if (request.getParameter("update") != null) {
			String suname=request.getParameter("suname");
			String spass=request.getParameter("spass");
			String sname=request.getParameter("sname");
			String sphone=request.getParameter("sphone");
			String semail=request.getParameter("semail");
			Student student=new Student(suname, spass, sname, sphone, semail);
			StudentLogic lc=new StudentLogic(); 
			try {
				if(lc.update(suname, student))
				{
					request.setAttribute("studentUpdate","Successfully Updated.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("studentUpdate","Error.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("updatepass") != null) {
		 
			String spass=request.getParameter("spass");
			String semail=request.getParameter("semail");
			StudentLogic lc=new StudentLogic(); 
			try {
				if(lc.updatePass(semail, spass))
				{
					request.setAttribute("studentUpdate","Successfully Updated.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("studentUpdate","Error.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
