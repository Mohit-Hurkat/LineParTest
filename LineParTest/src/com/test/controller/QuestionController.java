package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bean.Question;
import com.test.bean.Subject;
import com.test.bl.QuestionLogic;
import com.test.bl.SubjectLogic;


 
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectLogic sLogic=new SubjectLogic();
	private Subject sub=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("ques");
		HttpSession session=request.getSession(false);
		int id=Integer.parseInt(request.getParameter("subject"));
		session.setAttribute("sessionSubjectId", id);
		if (session.getAttribute("call").equals("insert")){
			System.out.println("iasd");
			
			try {
				sub=sLogic.search(id);
					session.setAttribute("sessionSubject",sub);//use this attribute to abstract info
					response.sendRedirect("./Admin/AdminQuestion/insertQuestion.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else if(session.getAttribute("call").equals("delete")){
			try {
				sub=sLogic.search(id);
					session.setAttribute("sessionSubject",sub);//use this attribute to abstract info
					response.sendRedirect("./Admin/AdminQuestion/deleteQuestion.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		else if (session.getAttribute("call").equals("search")) {
			try {
				sub=sLogic.search(id);
					session.setAttribute("sessionSubject",sub);//use this attribute to abstract info
					response.sendRedirect("./Admin/AdminQuestion/searchQuestion.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		}
		else if (session.getAttribute("call").equals("displayAll")) {
			QuestionLogic qLogic=new QuestionLogic();
			try {
				sub=sLogic.search(id);
				List<Question> ques=qLogic.displayAll(sub.getSubjectId());
				if(ques!=null){
				session.setAttribute("sessionQuestionAll",ques);
					response.sendRedirect("./Admin/AdminQuestion/viewAllQuestion.jsp");
				}
				else{
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		}
		else if (session.getAttribute("call").equals("update")) {
			try {
				sub=sLogic.search(id);
					session.setAttribute("sessionSubject",sub);//use this attribute to abstract info
					response.sendRedirect("./Admin/AdminQuestion/updateQuestion.jsp");
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
