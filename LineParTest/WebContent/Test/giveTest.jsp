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
</head>
<body>
<%ArrayList<Question> ques=(ArrayList<Question>)session.getAttribute("quest"); %>>
<div class="form">
	<div class="tab-content">
	<ul class="tab-group">
	<%for (Question quest:ques){%>
		<li><input type="radio" name="choice" value="<%= quest.getQuestion()%>"></li>
		<li><input type="radio" name="choice" value="<%= quest.getChoice1()%>"></li>
		<li><input type="radio" name="choice" value="<%= quest.getChoice2()%>"></li>
		<li><input type="radio" name="choice" value="<%= quest.getChoice3()%>"></li>
		<li><input type="radio" name="choice" value="<%= quest.getChoice4()%>"></li>
		<%}%>
	</ul>
	</div>
</div>
</body>
</html>