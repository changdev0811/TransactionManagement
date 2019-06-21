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
        String forward = "/list-transactions.jsp";
        HttpSession session = request.getSession();
        String accountNo = (String) session.getAttribute("accountNo");
        System.out.println(accountNo);
        try {
            request.setAttribute("transactions", transactionsdao.getTransactions(accountNo));
            request.setAttribute("income", transactionsdao.getIncome());
            request.setAttribute("outgoing", transactionsdao.getOutgoing());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
