package com.example.EmployeeDirectory;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "EditDepartmentServlet")
public class EditDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.include(request, response);
        PrintWriter out = response.getWriter();

        String idd = request.getParameter("idd");
        String deptId = request.getParameter("dept");
        String deptName = request.getParameter("dname");
        System.out.println(idd + deptId + deptName);
        if (idd.equals("1")) {
            //update
            int status = DeptDao.update(deptName, deptId);

            if (status > 0) {
                response.sendRedirect("ShowDepartmentServlet");
            } else {
                response.sendRedirect("AdminMenu.jsp");
            }
        } else if (idd.equals("2")) {
            //delete
            int status = DeptDao.delete(Integer.parseInt(deptId));
            if (status > 0) {
                response.sendRedirect("ShowDepartmentServlet");
            } else {
                response.sendRedirect("AdminMenu.jsp");
            }

        } else if (idd.equals("3")) {
            //cancel
            response.sendRedirect("AdminMenu.jsp");
        }
    }
}
