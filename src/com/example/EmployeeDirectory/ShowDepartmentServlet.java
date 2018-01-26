package com.example.EmployeeDirectory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by amaid on 1/25/2018.
 */
@WebServlet(name = "ShowDepartmentServlet")
public class ShowDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("Header.jsp");
        rd.include(request, response);
        PrintWriter out = response.getWriter();


        out.println(" out.println(\"<h1 style='background-color: #FFCC66; text-align: center;'><span style='color: azure'><span style='color: black;' >D</span>partments</span></h1>\");");
        List<Dept> list = DeptDao.getAllDepartment();
        for (Dept e : list) {
            out.print("<ul>" +
                      "<li><a href='EditDepartment.jsp?name=" + e.getName() + "&id=" + e.getId() + "'>" + e.getName() + "</a></li>" +
                      "</ul>");

        }
        out.println("<a href='AddDepartment'><span style=' border: 5px solid bisque; '>Insert </span></a>");
        out.close();
    }
}
