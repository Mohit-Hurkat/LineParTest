package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bean.Question;
import com.test.bl.QuestionLogic;
import com.test.bl.ResultLogic;

public class TestResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionLogic qLogic=new QuestionLogic();
	private ResultLogic rLogic=new ResultLogic() ; 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String username=(String)session.getAttribute("sessionUsername");
		ArrayList<Question> ques=(ArrayList<Question>)session.getAttribute("Questions");
		int count=0;
		System.out.println("12");
		try {
			Enumeration<String> questions=request.getParameterNames();
			while(questions.hasMoreElements()){
				String question=questions.nextElement();
				int questionId=Integer.parseInt(question);
				String ans=qLogic.answer(questionId);
				System.out.println(ans+" = "+request.getParameter(question));
				if(request.getParameter(question).equals(ans)){
					count++;
				}
				System.out.println(count);
			}

			String Coun=Integer.toString(count*10).concat(" %");
			session.setAttribute("sessionResult", count);
			session.setAttribute("message","You Scored");
			session.setAttribute("message1",Coun);
			Question questt=ques.get(0);
			int subId=questt.getSubjectId();
			System.out.println(subId);
			rLogic.set(username,subId,count*10);
			response.sendRedirect("./lost.jsp");
			}
		catch (Exception e) {
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}