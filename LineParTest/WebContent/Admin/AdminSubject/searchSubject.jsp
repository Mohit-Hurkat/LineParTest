<%@page import="com.test.bean.Subject" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../admin.css">
    <script src="../../javascript/homepage.js" type="text/javascript"></script>
</head>
<body>
<%@include file="../admin.jsp" %>
<div class="form">
      
      <div class="tab-content">
        <div id="signup">   
          <h1 class="sign">Display Subject</h1>
          <form action="./" method="post">
          
          <div class="top-row">
          
          	<div class="field-wrap">
            <label>
            Subject Id<span class="req">*</span>
            </label>
            <input type="text"  name="subjectId" required autocomplete="off"/>
            <button class="button button-block" name="search">Search</button>
            </div>
            </div>
            </form>
            </div>   
            </div>       
      </div><!-- tab-content -->
      <div class="form">
      <div class="tab-content" style="color:white;">
       <% Subject subject= (Subject)request.getAttribute("subjectSearch");%>
       <%out.print(subject);%>
</div>
</div>
</body>
</html>