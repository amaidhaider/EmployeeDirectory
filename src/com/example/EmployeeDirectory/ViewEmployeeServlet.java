package com.example.EmployeeDirectory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by amaid on 1/25/2018.
 */
@WebServlet(name = "ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1 style='background-color: #FFCC66; text-align: center;'><span style='color: azure;' >T</span>echnosoft <span style='color: azure;'><span style='color: black;' >E</span>mployee </span><span style='color: azure;'>D</span>irectory</h1>");
        out.println();
        out.println();
        out.println();
        out.println("<h1 style='background-color: #FFCC66; text-align: center;'><span style='color: azure'><span style='color: black;' >E</span>mployee</span></h1>");

        String n=request.getParameter("id");

         Emp e= EmpDao.getEmployeeById(Integer.parseInt(n));
             out.println("<ul>" +
                         "<li>Employee Id :"+e.getId()+"</li>");
             out.println("<li>Employee Name :"+e.getName()+"</li>");
             out.println("<li>Employee Title :"+e.getTitle()+"</li>");
             out.println("<li>Employee Department :"+e.getDepartment()+"</li>");
             out.println("<li>Employee Workphone :"+e.getWorkPhone()+"</li>");
             out.println("<li>Employee Email :"+e.getEmail()+"</li>" +
                         "</ul>");
             out.println("<span style='padding-left: 239px;'><a href='EmployeeDetailServlet'><span style='color: black ; border : 5px solid #FFCC66'>Back</span></a></span>");



    }
}
