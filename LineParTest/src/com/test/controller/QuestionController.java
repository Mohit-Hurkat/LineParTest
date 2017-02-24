package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.Question;
import com.test.bl.QuestionLogic;


 
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		if (request.getParameter("insert") != null) {
			 
			QuestionLogic lc=new QuestionLogic(); 
			int quesId=Integer.parseInt(request.getParameter("quesid"));
			int subId=Integer.parseInt(request.getParameter("subid"));
			String question=request.getParameter("question");
			int ans=Integer.parseInt(request.getParameter("answer"));
			String ch1=request.getParameter("choice1");
			String ch2=request.getParameter("choice2");
			String ch3=request.getParameter("choice3");
			String ch4=request.getParameter("choice4");
			String answer=request.getParameter("ans");
			Question ques=new Question(quesId, subId, question, ans, ch1, ch2, ch3, ch4, answer);
			
			try {
				if(lc.insert(ques))
				{
					request.setAttribute("questioninsert","Successfully Inserted.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./question.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("questionInsert"," Error.");//use this attribute to abstract info
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
			QuestionLogic lc=new QuestionLogic(); 
			int quesId=Integer.parseInt(request.getParameter("quesid"));
			try {
				if(lc.delete(quesId))
				{
					request.setAttribute("questionDelete","Successfully Deleted.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./question.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("questionDelete","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		      
		}
		else if (request.getParameter("search") != null) {
			QuestionLogic lc=new QuestionLogic(); 
			int quesId=Integer.parseInt(request.getParameter("quesid"));
			try {
				Question ques=lc.search(quesId);
				if(ques.getQuestionId()==quesId)
				{
				request.setAttribute("questionSearch", ques);//use this attribute to abstract data
				RequestDispatcher dispatch=request.getRequestDispatcher("./question.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("questionSearch","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("display") != null) {
			 
			QuestionLogic lc=new QuestionLogic(); 
			int quesId=Integer.parseInt(request.getParameter("quesid"));
			try {
				List<Question> ques=lc.displayAll(quesId);
				if(ques!=null)
				{
				request.setAttribute("questionDisplay", ques);//use this attribute to display data
				RequestDispatcher dispatch=request.getRequestDispatcher("./question.jsp");
				dispatch.forward(request, response);
				}
				else
				{
					request.setAttribute("questionDisplay","Error.");//use this attribute to abstract info
					RequestDispatcher dispatch=request.getRequestDispatcher("./lost.jsp");//change this to appropriate path
					dispatch.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
			 
				e.printStackTrace();
			}
		  
		}
		else if (request.getParameter("update") != null) {
			QuestionLogic lc=new QuestionLogic(); 
			int quesId=Integer.parseInt(request.getParameter("quesid"));
			int subId=Integer.parseInt(request.getParameter("subid"));
			String question=request.getParameter("question");
			int ans=Integer.parseInt(request.getParameter("answer"));
			String ch1=request.getParameter("choice1");
			String ch2=request.getParameter("choice2");
			String ch3=request.getParameter("choice3");
			String ch4=request.getParameter("choice4");
			String answer=request.getParameter("ans");
			Question ques=new Question(quesId, subId, question, ans, ch1, ch2, ch3, ch4, answer); 
			
			try {
				if(lc.update(quesId, ques))
				{
					request.setAttribute("questionUpdate","Successfully Updated.");//use this attribute to display data
					RequestDispatcher dispatch=request.getRequestDispatcher("./question.jsp");
					dispatch.forward(request, response);
				}
				else	 
				{
					request.setAttribute("questionUpdate","Error.");//use this attribute to abstract info
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
