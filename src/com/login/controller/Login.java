package com.login.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.login.dao.LoginDao;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("accountNo");
        String pinNo = request.getParameter("pinNo");

        LoginDao dao=new LoginDao();

        if(dao.check(accountNo, pinNo)){
            HttpSession session=request.getSession();
            session.setAttribute("accountNo",accountNo);
            response.sendRedirect("transaction.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
    }

}
