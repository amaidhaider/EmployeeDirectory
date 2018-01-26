package com.example.EmployeeDirectory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by amaid on 1/26/2018.
 */
@WebServlet(name = "ServletUserLogin")
public class ServletUserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name =request.getParameter("uname");
        String pass =request.getParameter("pass");
        //System.out.println(name + pass);
        EmployeeLogin e = EmpDao.checkLogin(name,pass);
        // System.out.println(e.id + e.name + e.password);
        if(e.name != null){
            response.sendRedirect("EmployeeDetailServlet");

        }else{
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
