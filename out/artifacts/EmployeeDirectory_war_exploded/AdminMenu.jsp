<%--
  Created by IntelliJ IDEA.
  User: amaid
  Date: 1/25/2018
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration Menu</title>
</head>
<body>

<%request.getRequestDispatcher("Header.jsp").include(request,response);%>
<h1 style="background-color: #FFCC66; text-align: center;"><span style="color: azure"><span style="color: black;" >A</span>dministration</span><span style="color: black"><span style="color: azure;" >M</span>enu</span></h1>
<ul>
    <li><a href="">Members</a></li>
    <li><a href="ShowDepartmentServlet">Departments</a></li>
</ul>


</body>
</html>
