package com.dao;

import com.model.Transaction;

import java.sql.*;
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

    public void addTransaction(Transaction transaction){
        try{
            String sql="INSERT INTO transactions "
                    + "(AccountNo, Description, Criteria, Result, Stack, Price, Amount, Direction, TimeStamp) "
                    + "VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, transaction.getAccountNo());
            st.setString(2, transaction.getDescription());
            st.setString(3, transaction.getCriteria());
            st.setString(4, transaction.getResult());
            st.setDouble(5, transaction.getStack());
            st.setDouble(6, transaction.getPrice());
            double amount = transaction.getStack() * transaction.getPrice();
            st.setDouble(7, amount);
            st.setString(8, transaction.getDirection());
            st.setTimestamp(9, getCurrentTimeStamp());
            st.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Transaction> getTransactions(String accountNo) throws SQLException {
        int userLevel = this.getUserLevel(accountNo);
        String query;
        if(userLevel == 1){
            query = "select * from transactions where AccountNo="+accountNo;
        }else{
            query = "select * from transactions ";
        }

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            Transaction transaction = new Transaction();
            transaction.setAccountNo(res.getInt("accountNo"));
            transaction.setDescription(res.getString("description"));
            transaction.setCriteria(res.getString("criteria"));
            transaction.setResult(res.getString("result"));
            transaction.setStack(res.getDouble("stack"));
            transaction.setPrice(res.getDouble("price"));
            transaction.setAmount(res.getDouble("amount"));
            transaction.setDirection(res.getString("direction"));

            transactions.add(transaction);
        }
        return transactions;
    }

    public Integer getUserLevel(String accountNo) throws SQLException {
        String query = "select UserLevel from clients where AccountNo="+accountNo;
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        int userLevel = 1;
        while (res.next()) {
            userLevel = res.getInt("userLevel");
        }
        return userLevel;
    }

    public Double getIncome() throws SQLException {
        double income = 0;
        String query = "select Amount, Direction from transactions";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            double amount = res.getDouble("amount");
            String direction = res.getString("direction");
            if(direction.equals("Credit")){
                income = income + amount;
            }
        }
        return income;
    }

    public Double getOutgoing() throws SQLException {
        double outgoing = 0;
        String query = "select Amount, Direction from transactions";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            double amount = res.getDouble("amount");
            String direction = res.getString("direction");
            if(direction.equals("Debit")){
                outgoing = outgoing + amount;
            }
        }
        return outgoing;
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
}
