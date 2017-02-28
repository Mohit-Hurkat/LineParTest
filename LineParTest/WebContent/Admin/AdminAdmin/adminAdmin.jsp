<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylemy.css"/>
    <script src="../javascript/homepage.js" type="text/javascript"></script>
 <script>
$(document).ready(function() {
        $("#updateInfo").addClass("active");
});

function Validation() {
	    var x = document.getElementById("updatePassword").value;
	    var y = document.getElementById("confirmPassword").value;
	    if(x!=y){
	    	alert("Password doesn't match.");
	    	 document.getElementById('confirmPassword').value="";
	    	 document.getElementById('updatePassword').value="";
	    	return false;
	    }
	    return true;
	
}
</script>
<title>Insert title here</title>
</head>
<body>
<div class="form">
<form action="${pageContext.request.contextPath}/AdminController" method="post">
          
          <div class="top-row">
            <div class="field-wrap">
            <label class="active highlight">            
            New Password<span class="req">*</span>
            </label>
            <input type="password"  name="password" id="updatePassword" required autocomplete="off"/>
          	</div>   
          	<div class="field-wrap">
            <label class="active highlight">            
           Confirm Password<span class="req">*</span>
            </label>
            <input type="password"  name="password" id="confirmPassword" required autocomplete="off" onBlur="Validation();"/>
          	</div>  
           
            </div>
            
          <input type="submit" class="button button-block" name="update" value="Submit">
          </div><!-- top-row -->
</form><br>

 <form action="${pageContext.request.contextPath}/Student/student.jsp" method="post">
 <input type="submit" class="button-block" value="Back">
 </form>
</body>
</html>