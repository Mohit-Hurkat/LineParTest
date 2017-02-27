<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./Admin/admin.css">
    <script src="./javascript/homepage.js" type="text/javascript"></script>
</head>
<body>
	<div class="form">
      
      	<ul class="tab-group">
        	<li class="tab " id="question"><a>Question</a>
        	<ul class="dropdown-content">
        		<li style="height: 49px;"></li>
        	 	
        		<li class="float"><a href="./Admin/adminQuestion.jsp"> Delete Question</a></li>
        		<li class="float"><a href="./Admin/adminQuestion.jsp">Insert Question</a></li>
        		<li  class="float"><a href="./Admin/adminQuestion.jsp">Update Question</a></li>
        		<li  class="float"><a href="./QuestionController?display=display"> View All Questions</a></li>
        	</ul>
        	</li>
        	<li class="tab" id="updateInfo"><a>Student</a>
        	<ul class="dropdown-content">
        		<li style="height: 49px;"></li>
        		<li class="float"><a  href="./Admin/adminStudent.jsp">Delete Student</a></li>
        		<li class="float"><a  href="./Admin/adminStudent.jsp">Search Student</a></li>
        		<li class="float"><a  href="./Admin/adminStudent.jsp">View All Students</a></li>
        	</ul>
			 </li>
         	<li class="tab " id="subject" ><a>Subject</a>
         	<ul class="dropdown-content">
        		<li style="height: 49px;"></li>
        		<li class="float"><a href="./Admin/adminSubject.jsp">Delete Subject</a></li>
        		<li class="float"><a href="./Admin/adminSubject.jsp">Display Subject</a></li>
        		<li class="float"><a href="./Admin/adminSubject.jsp">Insert Subject</a></li>
        		<li class="float"><a href="./Admin/AdminSubject/searchSubject.jsp">Search Subject</a></li>
        		<li class="float"><a href="./Admin/adminSubject.jsp">Update Subject</a></li>
        	</ul>
        	</li>
        	<li class="tab " id="update" ><a>Admin</a>
        	<ul class="dropdown-content">
        		<li style="height: 49px;"></li>
        		<li class="float"><a href="./Admin/adminAdmin.jsp">Update Admin</a></li>
        	</ul>
        	</li>
		</ul>
	</div> <!-- /form -->
<form action="./QuestionController">
<input type="submit" name="display" value="display">
</form>
</body>
</html>