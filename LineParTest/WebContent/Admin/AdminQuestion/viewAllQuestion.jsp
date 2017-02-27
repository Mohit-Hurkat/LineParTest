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
    <script src="../javascript/homepage.js" type="text/javascript"></script>
    <script>
$(document).ready(function() {
        $("#giveTest").addClass("active");
});
</script>
</head>
<body>
<% ArrayList<Question> subList=(ArrayList<Question>)request.getAttribute("questionDisplay"); %>
<div class="form">
<div class="tab-group">


 <div style="color: white;">
 	<h2>Subject ID: <%=subList.get(1).getSubjectId() %></h2>
	<table border="1" style="width:100%;">
	<tr>
	<th>Question Id</th>
	<th>Question</th>
	<th>Answer</th>
	</tr>
	<%for (Question sub:subList){%>
		<tr>
			<td><%=sub.getQuestionId()%></td>
			<td><%=sub.getQuestion()%></td> 
			<td><%=sub.getAnswer()%></td> 
		</tr>
	<% } %>
</table>
 </div>
 </div>
 </div>
 <br>
 <form action="./Admin/admin.jsp" method="post">
 <input type="submit" class="button button-block" value="BACk">
 </form>
</body>
</html>