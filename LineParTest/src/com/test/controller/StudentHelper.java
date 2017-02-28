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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.test.bean.Result;
import com.test.bean.Student;
import com.test.bean.Subject;
import com.test.bl.ResultLogic;
import com.test.bl.StudentLogic;
import com.test.bl.SubjectLogic;
import com.test.bl.TestLogic;

import javafx.scene.control.Alert;


public class StudentHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentLogic lc=new StudentLogic(); 
	 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if (request.getParameter("display") != null) {
			 
			SubjectLogic lc=new SubjectLogic();
			try {
				System.out.println("hell4");
				List<Subject> sub=lc.displayAll();
				if(sub!=null)
				{
					System.out.println("hell");
				request.setAttribute("subjectDisplay", sub);//use this attribute to display data
				RequestDispatcher dispatch=request.getRequestDispatcher("./Student/studentGiveTest.jsp");
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
			String suname=(String)session.getAttribute("sessionUsername");
			System.out.println(suname);
            String spass=request.getParameter("updatePassword");
			String sname=request.getParameter("updateName");
			String sphone=request.getParameter("updatePhone");
			String semail=request.getParameter("updateEmail");
			Student student=new Student(suname, spass, sname, sphone, semail);
			try {
				
				if(lc.update(suname, student))
				{
					System.out.println(suname);
					System.out.println( "if");
					request.setAttribute("studentUpdate","Successfully Updated.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./Student/updateStudent.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					System.out.println( "else");
					request.setAttribute("studentUpdate","Error.");
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println( e);
				e.printStackTrace();
			}
		  
		}
		
		else if(request.getParameter("result") != null)//check the parameter name
		{
			TestLogic lc=new TestLogic(); 
			String username=(String) session.getAttribute("sessionUsername");
			int subjectId=Integer.parseInt(request.getParameter("subjectId"));
			try {
				int res=lc.result(username, subjectId);
				if(res>0)
				{
					request.setAttribute("testResult", res);//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./studentResult.jsp");
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
		
		else if (request.getParameter("retrieve") != null) {
			String studentName=(String)session.getAttribute("sessionUsername");
			try {
				Student student=lc.search(studentName);
				session.setAttribute("studentUpdate", student);
					response.sendRedirect("./Student/studentUpdateInfo.jsp");					
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println( e);
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
		        response.sendRedirect("./Student/student.jsp");
			}
			else
			{
				response.sendRedirect("./lost.jsp");
			}
		}
		catch( NullPointerException e){
			request.setAttribute("message","Invalid Credentials");
	    	request.setAttribute("message1","Visit lenskart for better vision.");
	    	RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");
			dispatch.forward(request, response);			
		}
		catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("./lost.jsp");
		}
		
		
		}
	else if (request.getParameter("resultstudent") != null) {//check the parameter name
		ResultLogic rc=new ResultLogic(); 
		String username=(String) session.getAttribute("sessionUsername");
		try {
			List<Result> result1=rc.show(username);
			if(result1!=null)
			{
				session.setAttribute("testResult",result1);//use this attribute to display data
				response.sendRedirect("./Student/studentPrevResult.jsp");
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
		
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}
