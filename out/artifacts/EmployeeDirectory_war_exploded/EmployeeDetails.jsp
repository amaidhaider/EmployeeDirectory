<%--
  Created by IntelliJ IDEA.
  User: amaid
  Date: 1/24/2018
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%@ page import="com.example.EmployeeDirectory.EmpDao" %>
<%@ page import="com.example.EmployeeDirectory.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.EmployeeDirectory.Dept" %>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>

<h1 style="background-color: #FFCC66; text-align: center;"><span style="color: azure;" >T</span>echnosoft <span style="color: azure;"><span style="color: black;" >E</span>mployee </span><span style="color: azure;" >D</span>irectory</h1>
<center>
    <img src="homelogo.png" alt="Mountain View" width="50" height="50" style="padding-right: 50px">

    <img src="adminlogo1.jpg" alt="Mountain View" width="50" height="50"></center>
<center><a href="#" style="padding-right: 15px">Home</a> <a href="AdminLogin.jsp">Administration</a></center>

<center><form action="EmployeeDetailServlet" method="post" >
    <h1 style="background-color: #FFCC66; text-align: center;"><span style="color: azure"><span style="color: black;" >S</span>earch</span></h1>
    <h1 style="background-color: #FFCC66; text-align: left; float: left;"><span style="color: azure"><span style="color: black;" >M</span>anOfMonth</span></h1>
    <%
        List<Emp> list = EmpDao.getAllEmployees();
        Emp manOfEmp = new Emp();
        for (Emp e : list) {
             boolean check = e.isManOfMonth();
            if(check){
                manOfEmp.setName(e.getName());
                break;
            }

        }
           System.out.println(manOfEmp.getName());
    %>
    <h3 style="float: left;margin-top: 70px;margin-left: -168px; border: 5px solid #FFCC66;"><%= manOfEmp.getName()%></h3>



    <table>
        <tr><td>Department</td><td>
            <select name="department" style="width:150px">
                <option value="All">All</option>
                <option value="Software">Software</option>
                <option value="Administration">Administration</option>
                <option value="IT">IT</option>
            </select>
        </td></tr>
        <tr><td>Name</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>

        <tr><td colspan="2" style="padding-left: 196px;"><input type="submit" value="Search"/></td></tr>
    </table>


</form>

</center>
</body>
</html>
