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

import com.test.bean.Subject;
import com.test.bl.SubjectLogic;

/**
 * Servlet implementation class AdminQuestionController
 */
public class AdminQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
			SubjectLogic lc=new SubjectLogic();
			try {
				System.out.println("hell4");
				List<Subject> sub=lc.displayAll();
				if(sub!=null)
				{
					if (request.getParameter("display1") != null) {
						session.setAttribute("call","delete");
					}
					else if (request.getParameter("display2") != null) {
						session.setAttribute("call","insert");
					}
					else if (request.getParameter("display3") != null) {
						session.setAttribute("call","update");
					}
					else if (request.getParameter("display4") != null) {
						session.setAttribute("call","displayAll");
					}
					System.out.println("hell");
				session.setAttribute("subjectDisplay", sub);//use this attribute to display data
				response.sendRedirect("../Admin/AdminQuestion/Question.jsp");
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
