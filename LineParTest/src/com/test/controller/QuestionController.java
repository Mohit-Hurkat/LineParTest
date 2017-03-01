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
	private QuestionLogic qLogic=new QuestionLogic();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //System.out.println("ques");
		HttpSession session=request.getSession(false);
		int id=Integer.parseInt(request.getParameter("subject"));
		session.setAttribute("sessionSubjectId", id);
		
		if (session.getAttribute("call").equals("insert")){
			//System.out.println("iasd");
			try {
				sub=sLogic.search(id);
				
					session.setAttribute("sessionSubject",sub);//use this attribute to abstract info
					session.setAttribute("call", "insertIntoTable");
					 response.sendRedirect("./Admin/AdminQuestion/insertQuestion.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(session.getAttribute("call").equals("insertIntoTable")){
			int subjectId=Integer.parseInt(request.getParameter("subjectId"));
			String question=request.getParameter("question");
			String op1=request.getParameter("op1");
			String op2=request.getParameter("op2");
			String op3=request.getParameter("op3");
			String op4=request.getParameter("op4");
			int answer=Integer.parseInt(request.getParameter("answer"));
			Question q=new Question(id, subjectId, question, answer, op1, op2, op3, op4, op1);
			try {
				if(qLogic.insert(q)){
					session.setAttribute("message","Inserted Successfully");
						response.sendRedirect("./Admin/AdminQuestion/final.jsp");
					}
				else
				{
					session.setAttribute("message","error");
					response.sendRedirect("./lost.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(session.getAttribute("call").equals("deleteQues")){
			int quesId=Integer.parseInt(request.getParameter("subject"));
			try {
				if(qLogic.delete(quesId)){
					session.setAttribute("message","Deleted Successfully");
						response.sendRedirect("./Admin/AdminQuestion/final.jsp");
					}
				else
				{
					session.setAttribute("message","error");
					response.sendRedirect("./lost.jsp");
				}
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
		
		
		else if(session.getAttribute("call").equals("delete")){
			try {
				sub=sLogic.search(id);
				List<Question> ques=qLogic.displayAll(sub.getSubjectId());
				if(ques!=null){
				session.setAttribute("sessionQuestionAll",ques);
				session.setAttribute("call", "deleteQues");
					response.sendRedirect("./Admin/AdminQuestion/deleteQuestion.jsp");
				}
				else{
					
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
