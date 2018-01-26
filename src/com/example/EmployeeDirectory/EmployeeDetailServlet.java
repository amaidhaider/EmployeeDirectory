package com.example.EmployeeDirectory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;


/**
 * Created by amaid on 1/24/2018.
 */
@WebServlet(name = "EmployeeDetailServlet")
public class EmployeeDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/EmployeeDetails.jsp");
        rd.include(request, response);
        PrintWriter out = response.getWriter();

        String dept = request.getParameter("department");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        List<Emp> list = EmpDao.getSearchedEmployee(dept, name, email);
        out.println("<h1 style='background-color: #FFCC66; text-align: center;'><span style='color: azure;' >T</span>echnosoft <span style='color: azure;'><span style='color: black;' >E</span>mployee </span><span style='color: azure;'>D</span>irectory</h1>");
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Name</th>" +
                  "<th>Title</th>" +
                  "<th>Department</th>" +
                  "<th>Workphone</th>" +
                  "<th>Email</th></tr> ");
        for (Emp e : list) {
            out.print("<tr>" +
                    "<td><a href = 'ViewEmployeeServlet?id=" + e.getId() + "'> " + e.getName() + "</a ></td>" +
                    "<td>" + e.getTitle() + "</td>" +
                    "<td>" + e.getDepartment() + "</td>" +
                    "<td>" + e.getWorkPhone() + "</td>" +
                    "<td>" + e.getEmail() + "</td >" +
                    "</tr>");
        }
        out.print("</table>");

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/EmployeeDetails.jsp");
        rd.include(request, response);
        PrintWriter out = response.getWriter();
        List<Emp> list = EmpDao.getAllEmployees();
        out.println("<h1 style='background-color: #FFCC66; text-align: center;'><span style='color: azure;'><span style='color: black;' >E</span>mployee </span><span style='color: azure;'>D</span>irectory</h1>");
        out.print("<table border='1' width='100%'");
        out.print("<tr>" +
                  "<th>Name</th>" +
                  "<th>Title</th>" +
                  "<th>Department</th>" +
                  "<th>Workphone</th>" +
                  "<th>Email</th>" +
                  "</tr>");
        for (Emp e : list) {
            out.print("<tr>" +
                    "<td><a href = 'ViewEmployeeServlet?id=" + e.getId() + "'> " + e.getName() + "</a ></td>" +
                    "<td>" + e.getTitle() + "</td>" +
                    "<td>" + e.getDepartment() + "</td>" +
                    "<td>" + e.getWorkPhone() + "</td>" +
                    "<td >" + e.getEmail() + "</td >" +
                    "</tr > ");
        }
        out.print("</table>");

        out.close();
    }
}
