<%--
  Created by IntelliJ IDEA.
  User: amaid
  Date: 1/25/2018
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Department</title>
</head>
<body>
<h1 style="background-color: #FFCC66; text-align: center;"><span style="color: azure"><span style="color: black;" >D</span>epartments</span></h1>
<form action="" method="post" >
<label>Name : </label><input type="text" name="dname" value='<%=request.getParameter("name")%>'><br>

<a href="EditDepartmentServlet?idd=1&dept=<%=request.getParameter("id")%>">Update</a><br>
<a href="EditDepartmentServlet?idd=2&dept=<%=request.getParameter("id")%>">Delete</a><br>
<a href="EditDepartmentServlet?idd=3&dept=<%=request.getParameter("id")%>">Cancel</a>
</form>
</body>
</html>

