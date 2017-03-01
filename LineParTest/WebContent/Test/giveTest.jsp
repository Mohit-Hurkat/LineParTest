<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Question" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style1.css"/>
<script src="${pageContext.request.contextPath}/javascript/test.js" type="text/javascript"></script>
<style type="text/css">
body{
color:white;
font-size:20px;
}
input[type=radio]{
height:auto;
width: auto;
display:inline;
}
#timer_div{
float:left;
}
</style>


</head>
<body>
<%ArrayList<Question> ques=(ArrayList<Question>)session.getAttribute("Questions");
%>
<%int que=0; %>
<div class="form">	
<%for (Question quest:ques){%>
	<div class="h">
	<ol class="mySlides">
		<h3>QuestionNo: <%=++que%></h3>
		<h3><%= quest.getQuestion()%></h3>
		<li><input type="radio" name="<%= quest.getQuestionId()%>" value="<%= quest.getQuestionId()%>"><%=(String)quest.getChoice1()%></li>
		<li><input type="radio" name="<%= quest.getQuestionId()%>" value="<%= quest.getQuestionId()%>"><%=(String)quest.getChoice2()%></li>
		<li><input type="radio" name="<%= quest.getQuestionId()%>" value="<%= quest.getQuestionId()%>"><%=(String)quest.getChoice3()%></li>
		<li><input type="radio" name="<%= quest.getQuestionId()%>" value="<%= quest.getQuestionId()%>"><%=(String)quest.getChoice4()%></li>
			</ol>
		</div>
				<%}%>
							<button class="left" id="lef" onclick="plusDivs(-1)">&#10094;</button>
  <button class="right" id="rig" onclick="plusDivs(1)">&#10095;</button> 
  <div id="timer_div"></div>
	</div>
</body>
</html>