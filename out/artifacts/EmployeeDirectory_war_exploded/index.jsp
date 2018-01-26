<%--
  Created by IntelliJ IDEA.
  User: amaid
  Date: 1/24/2018
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1 style="background-color: #FFCC66; text-align: center;"><span style="color: azure;" >T</span>echnosoft <span style="color: azure;"><span style="color: black;" >E</span>mployee </span><span style="color: azure;" >D</span>irectory</h1>
<center>
    <img src="homelogo.png" alt="Mountain View" width="50" height="50" style="padding-right: 50px">

    <img src="adminlogo1.jpg" alt="Mountain View" width="50" height="50"></center>
<center><a href="#" style="padding-right: 15px">Home</a> <a href="AdminLogin.jsp">Administration</a></center>


<form action="ServletUserLogin" method="post" style="text-align: center;">
    <h1 style="background-color: #FFCC66; text-align: center;"><span style="color: azure"><span style="color: black;" >E</span>mployee</span><span style="color: azure"><span style="color: black;" >L</span>ogin</span></h1>
    <label style="padding-right: 23px">Login</label> <input type="text" name="uname"><br/>
    <label>Password</label> <input type="text" name="pass"><br/>
    <input type="submit" value="login" style="    margin-right: 192px;">
</form>
</body>
</html>
