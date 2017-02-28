<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
    <meta charset="UTF-8">
    <title>Typed.js - Type your heart out</title>
    <!-- Get jQuery -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="javascript/typed.js" type="text/javascript"></script>
    <script>
    $(function(){

        $("#typed").typed({
            stringsElement: $('#typed-strings'),
            typeSpeed: 30,
            backDelay: 500,
            loop: false,
            contentType: 'html', // or text
            // defaults to false for infinite loop
            loopCount: false,
            callback: function(){ foo(); },
            resetCallback: function() { newTyped(); }
        });

        $(".reset").click(function(){
            $("#typed").typed('reset');
        });

    });

    function newTyped(){ /* A new typed object */ }

    function foo(){ console.log("Callback"); }

    </script>
    <link href="stylemy.css" rel="stylesheet"/>
    <style>
        /* code for animated blinking cursor */
        .typed-cursor{
            opacity: 1;
            font-weight: 100;
            -webkit-animation: blink 0.7s infinite;
            -moz-animation: blink 0.7s infinite;
            -ms-animation: blink 0.7s infinite;
            -o-animation: blink 0.7s infinite;
            animation: blink 0.7s infinite;
        }
        @-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-webkit-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-moz-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-ms-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-o-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
    </style>
</head>
<body>
<% String message=(String)request.getAttribute("message");
String message1=(String)request.getAttribute("message1"); 
if(message==null){
	message="Oops! It looks like you're lost. ";
}
if(message1==null){
	message1="Sorry about that.";
}
%>
<div class="form">
    <div class="wrap">
        <h1 id="construct">Site Is Under-construction.</h1>

        <div class="type-wrap">
            <div id="typed-strings">
                <span><%=message%></span>
                <p><%=message1%></p>
                <p>Let me try and help. </p>
				<p>Click On The Below Links for Navigations. </p>
            </div>
            <span id="typed" style="white-space:pre;"></span>
        </div>

        <div class="links">
           <a href="home.jsp">Home</a> |  <a href="https://hurkat.in">Mohit Hurkat</a> | <a href="https://www.facebook.com/mohit.hurkat">Facebook</a> | <a href="https://twitter.com/mohithurkat">Twitter</a>
        </div>
    </div>
</div>
</body>
</html>
