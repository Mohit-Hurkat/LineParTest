<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Result" %>
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
        $("#prevResult").addClass("active");
});
</script>
<style>
.form{
text-align: center;
}
</style>
</head>
<body>
<% ArrayList<Result> resList=(ArrayList<Result>)session.getAttribute("testResult");%>
<div class="form">
<div class="tab-group">
 <div style="color: white;">
 <h1>Previous Results</h1>
	<table border="1" style="width:100%;">
	<tr>
	<th>Username</th>
	<th>Subject Id</th>
	<th>Result</th>
	<th>Date</th>
	</tr>
	<%for (Result res:resList){%>
		<tr>
			<td><%=res.getUsername() %></td>
			<td><%=res.getSubject() %></td>
			<td><%=res.getResult() %></td>
			<td><%=res.getDate() %></td>
		</tr>
	<% } %>
</table>
 </div><br>
</div>
<form action="./Student/student.jsp" method="post" name="backForm">
          <button class="back-button">BACK</button>
          </form>
</div>
</body>
</html>