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

import com.test.bean.Admin;
import com.test.bean.Student;
import com.test.bean.Subject;
import com.test.bl.AdminLogic;
import com.test.bl.StudentLogic;
import com.test.bl.SubjectLogic;
import com.test.bl.TestLogic;

 
 
public class StudentHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentLogic lc=new StudentLogic(); 
	 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();  
		if (request.getParameter("display") != null) {
			 
			SubjectLogic lc=new SubjectLogic();
			try {
				System.out.println("hell4");
				List<Subject> sub=lc.displayAll();
				if(sub!=null)
				{
					System.out.println("hell");
				request.setAttribute("subjectDisplay", sub);//use this attribute to display data
				RequestDispatcher dispatch=request.getRequestDispatcher("studentGiveTest.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					System.out.println("hell1");
					request.setAttribute("subjectDisplay","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException | NullPointerException e) {
				System.out.println("hell3");
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
		
		else if(request.getParameter("result") != null)//check the parameter name
		{
			TestLogic lc=new TestLogic(); 
			String username=request.getParameter("username");
			int subid=Integer.parseInt(request.getParameter("subid"));
			try {
				int res=lc.result(username, subid);
				if(res>0)
				{
					request.setAttribute("testResult", res);//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("testResult","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		      
		}
	else if (request.getParameter("login") != null) {
		
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		try {
			if(lc.check(user,pass))
			{
				session.setAttribute("sessionUsername", user);
				RequestDispatcher dispatch=request.getRequestDispatcher("./Student/student.jsp");
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
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}
