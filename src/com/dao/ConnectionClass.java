package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    public Connection getConnection()
            throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/bank", "root", "");

    }
}
