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
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}

$( document ).ready(function(){
	"#mySlides":not(first-child) {
	    display: none;
	}
});
</script>
<style type="text/css">
body{
color:white;
}
input[type=radio]{
height:auto;
width: auto;
display:inline;
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
							<button class="w3-button w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
  <button class="w3-button w3-display-right" onclick="plusDivs(1)">&#10095;</button>
	</div>
</body>
</html>