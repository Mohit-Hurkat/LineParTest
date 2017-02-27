<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.test.bean.Subject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../style1.css">
    <script src="../javascript/homepage.js" type="text/javascript"></script>
    <script>
$(document).ready(function() {
        $("#giveTest").addClass("active");
});
</script>
</head>
<body>
<%@include file="./studentHeader.jsp" %>
<% ArrayList<Subject> subList=(ArrayList<Subject>)request.getAttribute("subjectDisplay");%>
<div class="form">
<div class="tab-group" style=>
 <form action="./lost.jsp" method="post">
<%for (int i=0;i<subList.size();i++){%>
  <button type="button" name="subject" value="<%=subList.get(i).getSubject()%>"><%=subList.get(i).getSubject()%>
  </button>
	<% } %>
</form>
</div>
</div>
</body>
</html>