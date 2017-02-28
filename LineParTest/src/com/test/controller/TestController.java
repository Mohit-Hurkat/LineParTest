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

import com.test.bean.Result;
import com.test.bl.TestLogic;

 
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TestLogic lc=new TestLogic(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		int subjectId=Integer.parseInt(request.getParameter("subjectId"));
		String username=(String) session.getAttribute("sessionUsername");
		if (request.getParameter("giveTest") != null) {//check the parameter name			 
			try {
				List<Result> result=lc.giveTest(username, subjectId);
				System.out.println(result);
				System.out.println(subjectId);
				System.out.println(username);
				
				if(lc.giveTest(username, subjectId) == null)
				{
					if(lc.check_questions(subjectId,username))
					{
						if(lc.dateCheck(subjectId))
						{		
								request.setAttribute("sessionSubjectId", subjectId);
								RequestDispatcher dispatch=request.getRequestDispatcher("./Test/Rules.jsp");//change this to appropriate path
								dispatch.forward(request, response);				
						}
						else	 
						{ 
							request.setAttribute("message","Please check Test Time Period ");//use this attribute to abstract info
							RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
							dispatch.forward(request, response);
						}
					}
					else	 
					{
						request.setAttribute("message","Questions Yet To Be Updated.");
						request.setAttribute("message1","Please Select Another Subject..");//use this attribute to abstract info
						RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
						dispatch.forward(request, response);
					}
				}
				else	 
				{
					request.setAttribute("message","Test Already Given");
					request.setAttribute("message1",result.toString());
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");
					dispatch.forward(request, response);
				}
			} 
		catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		else if(request.getParameter("result") != null)//check the parameter name
		{
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
		 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}
