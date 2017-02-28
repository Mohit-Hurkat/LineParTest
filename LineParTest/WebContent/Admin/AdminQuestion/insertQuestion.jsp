<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style1.css"/>
    <script src="${pageContext.request.contextPath}/javascript/homepage.js" type="text/javascript"></script>
</head>
<body>
<div class="form"> 
      <div class="tab-content">
<h1>Inserted Form</h1>
</div>
 <br>
 <form action="${pageContext.request.contextPath}/Admin/adminSignIn.jsp" method="post">
 <input type="submit" class="button-block" value="Back">
 </form>
</div>
</body>
</html>