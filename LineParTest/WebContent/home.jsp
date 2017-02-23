<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="stylemy.css">
<script src="homepage.js"></script>
</head>
<body>
<div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Sign Up for Free</h1>
          
          <form action="/" method="post">
          
          <div class="top-row">
          
          	<div class="field-wrap">
            <label>
            Name<span class="req">*</span>
            </label>
            <input type="text"  name="name" required autocomplete="off"/>
            </div>
	        </div>
          
			<div class="field-wrap">
            <label>
            Email Address<span class="req">*</span>
            </label>
            <input type="email"  name="email" required autocomplete="off"/>
          	</div>
          
            <div class="field-wrap">
            <label>
           	Phone No(10 digits)<span class="req">*</span>
            </label>
            <input type="tel"  name="phone" pattern="^\d{10}$" required autocomplete="off" />
            </div>
          
            <div class="field-wrap">
            <label>
            Username<span class="req">*</span>
            </label>
            <input type="text"  name="username" required autocomplete="off" />
            </div>
  
            <div class="field-wrap">
            <label>
            Set A Password<span class="req">*</span>
            </label>
            <input type="password"  name="password" required autocomplete="off"/>
          	</div>   
          	    
          <button type="submit" class="button button-block"/>Get Started</button>
          </form>

        </div>
        
        <div id="login">   
          <h1>Welcome Back!</h1>
          
          <form action="/" method="post">
          
            <div class="field-wrap">
            <label>
              Username<span class="req">*</span>
            </label>
            <input type="text" name="username" required autocomplete="off">
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name="password" required autocomplete="off">
          </div>
          
          <p class="forgot"><a href="#">Forgot Password?</a></p>
          
          <button class="button button-block">Log In</button>
          
          </form>

        </div>
      </div><!-- tab-content -->
      
</div> <!-- /form -->
</body>
</html>