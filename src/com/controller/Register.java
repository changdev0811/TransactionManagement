package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.RegisterDao;

@WebServlet(name = "Register", urlPatterns = "/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("accountNo");
        String pinNo = request.getParameter("pinNo");
        String contactNo = request.getParameter("contactNo");

        RegisterDao dao=new RegisterDao();
        if(dao.register(accountNo, pinNo, contactNo)){
            response.sendRedirect("users.jsp");
        }
//        response.sendRedirect("users.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
