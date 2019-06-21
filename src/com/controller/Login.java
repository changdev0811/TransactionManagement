package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import com.dao.TransactionsDao;
import com.dao.UsersDao;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("accountNo");
        String pinNo = request.getParameter("pinNo");

        UsersDao usersDao=new UsersDao();
        TransactionsDao transactionsdao = new TransactionsDao();
        int userLevel = 1;
        try {
            userLevel = transactionsdao.getUserLevel(accountNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(usersDao.login(accountNo, pinNo)){
            HttpSession session=request.getSession();
            session.setAttribute("accountNo",accountNo);
            session.setAttribute("userLevel",userLevel);

            if(userLevel == 2){
                response.sendRedirect("users.jsp");
            }else{
                response.sendRedirect("transactions.jsp");
            }
        }else{
            request.getSession().setAttribute("errorMessage", "Wrong Account");
            response.sendRedirect("index.jsp");
        }
    }

}
