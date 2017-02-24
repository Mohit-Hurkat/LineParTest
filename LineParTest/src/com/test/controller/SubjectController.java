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
 
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("insert") != null) {
			 
			SubjectLogic lc=new SubjectLogic(); 
			String subname=request.getParameter("subname");
			String subdate1=request.getParameter("suddate1");
			String subdate2=request.getParameter("suddate2");
			 
			try {
				if(lc.insert( subname, subdate1,subdate2))
				{
					request.setAttribute("subjectinsert","Successfully Inserted.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./subject.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("subjectinsert"," Error.");//use this attribute to abstract info
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
			int subid=Integer.parseInt(request.getParameter("subid"));
			SubjectLogic lc=new SubjectLogic(); 
			try {
				if(lc.delete(subid))
				{
					request.setAttribute("subjectDelete","Successfully Deleted.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./subject.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("subjectDelete","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		      
		}
		else if (request.getParameter("search") != null) {
			int subid=Integer.parseInt(request.getParameter("subjectId"));
			SubjectLogic lc=new SubjectLogic();
			System.out.println("l");
			try {
				Subject sub=lc.search(subid);
				if(sub.getSubjectId()==subid)
				{				System.out.println("j");
				request.setAttribute("subjectSearch", sub);//use this attribute to abstract data
				RequestDispatcher dispatch=request.getRequestDispatcher("searchSubject.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("subjectSearch","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (NullPointerException e) {
				response.sendRedirect("../../lost.jsp");
				e.printStackTrace();
			}
			
			catch (ClassNotFoundException | SQLException e) {
				System.out.println("k");
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("display") != null) {
			 
			SubjectLogic lc=new SubjectLogic();
			try {
				List<Subject> sub=lc.displayAll();
				if(sub!=null)
				{
				request.setAttribute("subjectDisplay", sub);//use this attribute to display data
				RequestDispatcher dispatch=request.getRequestDispatcher("./subject.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("subjectDisplay","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("update") != null) {
			int subid=Integer.parseInt(request.getParameter("subid"));
			String subname=request.getParameter("subname");
			String subdate1=request.getParameter("suddate1");
			String subdate2=request.getParameter("suddate2");
			Subject sub=new Subject(subid, subname, subdate1, subdate2);
			SubjectLogic lc=new SubjectLogic();
			try {
				if(lc.update(subid,sub))
				{
					request.setAttribute("subjectUpdate","Successfully Updated.");//use this attribute to display data
					RequestDispatcher dispatch=request.getRequestDispatcher("./subject.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("subjectUpdate","Error.");//use this attribute to abstract info
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
				RequestDispatcher dispatch=request.getRequestDispatcher("./subject.jsp");
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
				RequestDispatcher dispatch=request.getRequestDispatcher("./subject.jsp");
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
