<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Admin/admin.css"/>
    <script src="../javascript/homepage.js" type="text/javascript"></script>
</head>
<body>
 	<%if(session.getAttribute("subjectInsert").equals("Successfully Inserted.")) %>
 	<%{ %>	<h1>Successfully Inserted.</h1><%} %>
 		<%  if(session.getAttribute("subjectDelete").equals("Successfully Deleted.")) %>
 		<%{ %>	<h1>Successfully Deleted.</h1><%} %>
 		<% if(session.getAttribute("subjectUpdate").equals("Successfully Updated.")) %>
 		<%{ %>	<h1>Successfully Updated.</h1><%} %>
 	<form action="${pageContext.request.contextPath}/Admin/adminSignIn.jsp">
 		<input type="submit" value="Back">
 	</form>
	
</body>
</html>