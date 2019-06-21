package com.controller;

import com.dao.TransactionsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.model.Transaction;

@WebServlet(name = "Transactions", urlPatterns = "/Transactions")
public class Transactions extends HttpServlet {

    private TransactionsDao transactionsdao;

    public Transactions() {
        super();
        transactionsdao = new TransactionsDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Transaction transaction = new Transaction();
        transaction.setAccountNo(Integer.parseInt(request.getParameter("accountNo")));
        transaction.setDescription(request.getParameter("description"));
        transaction.setCriteria(request.getParameter("criteria"));
        transaction.setResult(request.getParameter("result"));
        transaction.setStack(Double.parseDouble(request.getParameter("stack")));
        transaction.setPrice(Double.parseDouble(request.getParameter("price")));
        transaction.setDirection(request.getParameter("direction"));
        transactionsdao.addTransaction(transaction);

        response.sendRedirect("transactions.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("accountNo") == null) {
            response.sendRedirect("index.jsp");
        }else {
            String forward = "/list-transactions.jsp";
            String accountNo = (String) session.getAttribute("accountNo");
            int userLevel = 1;
            try {
                userLevel = transactionsdao.getUserLevel(accountNo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                request.setAttribute("transactions", transactionsdao.getTransactions(accountNo));
                request.setAttribute("income", transactionsdao.getIncome());
                request.setAttribute("outgoing", transactionsdao.getOutgoing());
                request.setAttribute("userLevel", userLevel);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }
}
