package com.dao;

import com.model.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransactionsDao {
    private Connection connection;

    public TransactionsDao(){
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Transaction> getTransactions() throws SQLException {
        String query = "select * from transactions";
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            Transaction transaction = new Transaction();
            transaction.setDescription(res.getString("description"));
            transaction.setCriteria(res.getString("criteria"));
            transaction.setResult(res.getString("result"));
            transaction.setStack(res.getDouble("stack"));
            transaction.setPrice(res.getDouble("price"));
            transaction.setAmount(res.getDouble("amount"));
            transaction.setDirection(res.getString("direction"));
            transaction.setUserID(res.getInt("userID"));

            transactions.add(transaction);
        }
        return transactions;
    }
}
