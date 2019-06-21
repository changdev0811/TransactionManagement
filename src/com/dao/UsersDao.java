package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.User;

public class UsersDao {
    private Connection connection;

    public UsersDao() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers() throws SQLException {
        String query = "select * from clients";
        ArrayList<User> users = new ArrayList<User>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            User user = new User();
            user.setAccountNo(Integer.parseInt(res.getString("accountNo")));
            user.setPinNo(Integer.parseInt(res.getString("pinNo")));
            user.setContactNo(Integer.parseInt(res.getString("contactNo")));
            users.add(user);
        }
        return users;
    }
}
