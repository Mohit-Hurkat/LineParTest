<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style1.css"/>
<title>Insert title here</title>
</head>
<body>
	
		<body>

		<% ArrayList<Student> studentList=(ArrayList<Student>)session.getAttribute("studentDisplay");%>
<div class="form">
<div class="tab-group">
 <form action="${pageContext.request.contextPath}/StudentController">

 	<div style="color: white;">
	<table border="1" style="width:100%;">
	<tr>
	<th>Username Name</th>
 
 
	</tr>
	<%for (Student stu:studentList){%>
		<tr>
			<td><%=stu.getUsername()%></td>
			
		 
		</tr>
	<% } %>
	</table>
 	</div><br>
 	<h1> Select  User :</h1><input type="text" name="username" ><br>
 	<input type="submit"  value="delete" name="delete">
</form>
</div><br>
<form action="./Admin/adminSignIn.jsp" method="post" name="backForm">
          <button class="back-button">BACK</button>
          </form>
</div>

</body>
</html>