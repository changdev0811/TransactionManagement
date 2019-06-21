package com.controller;

import com.dao.UsersDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Users", urlPatterns = "/Users")
public class Users extends HttpServlet {

    private UsersDao usersDao;

    public Users() {
        super();
        usersDao = new UsersDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("accountNo") == null) {
            response.sendRedirect("index.jsp");
        }else {
            String forward = "/list-users.jsp";
            int userLevel = (Integer) session.getAttribute("userLevel");
            try {
                request.setAttribute("users", usersDao.getUsers());
                request.setAttribute("userLevel", userLevel);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }
}
