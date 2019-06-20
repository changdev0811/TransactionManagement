package com.controller;

import com.dao.UsersDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Users", urlPatterns = "/Users")
public class Users extends HttpServlet {

    private UsersDao users;

    public Users() {
        super();
        users = new UsersDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "/list-users.jsp";
        try {
            request.setAttribute("users", users.getUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
