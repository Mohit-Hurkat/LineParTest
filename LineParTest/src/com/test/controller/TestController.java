package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.Subject;
import com.test.bl.SubjectLogic;
import com.test.bl.TestLogic;

 
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		if (request.getParameter("givetest") != null) {//check the parameter name
			 
			TestLogic lc=new TestLogic(); 
			String suname=request.getParameter("suname");
			int subid=Integer.parseInt(request.getParameter("subid"));
			 
			try {
				if(lc.giveTest(suname, subid))
				{
					request.setAttribute("giveTest","Successfully Given.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("giveTest"," Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else if(request.getParameter("result") != null)//check the parameter name
		{
			TestLogic lc=new TestLogic(); 
			String suname=request.getParameter("suname");
			int subid=Integer.parseInt(request.getParameter("subid"));
			try {
				int res=lc.result(suname, subid);
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
		else if (request.getParameter("check") != null) {//check the parameter name
			TestLogic lc=new TestLogic();
			int subid=Integer.parseInt(request.getParameter("subid"));
			try {
				if(lc.check(subid))
				{
				request.setAttribute("testCheck","Checked");//use this attribute to abstract data and use it in proper place
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("testCheck","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("datecheck") != null) {//check the parameter name
			 
			TestLogic lc=new TestLogic();
			int subid=Integer.parseInt(request.getParameter("subid"));
			try {
				 
				if(lc.dateCheck(subid))
				{
				request.setAttribute("testDateCheck","checked");//use this attribute to display data
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("testDateCheck","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("resultstudent") != null) {//check the parameter name
			TestLogic lc=new TestLogic(); 
			String suname=request.getParameter("suname");
			try {
				if(lc.result_student(suname))
				{
					request.setAttribute("testResult","Student Result.");//use this attribute to display data
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("showsubject") != null) {//use this function in appropriate place.It is not called directly through main page.
		 
			String suname=request.getParameter("suname");
			SubjectLogic lc=new SubjectLogic();
			try {
				List<Subject> sub=lc.showSubject(suname);
				if(sub!=null)
				{
				request.setAttribute("subjectShow", sub);//use this attribute to display data
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("subjectShow","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("subjectname") != null) {//use this function in appropriate place.It is not called directly through main page.
			 
			int subid=Integer.parseInt(request.getParameter("subid"));
			SubjectLogic lc=new SubjectLogic();
			try {
				String sub=lc.subname(subid);
				if(sub!=null)
				{
				request.setAttribute("subjectName", sub);//use this attribute to display data
				RequestDispatcher dispatch=request.getRequestDispatcher("./student.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("subjectName","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
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
