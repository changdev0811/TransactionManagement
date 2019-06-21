package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public boolean login(String accountNo,String pinNo) {
        try{
            String query = "select *from clients where AccountNo="+accountNo+" and PinNo="+pinNo;
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if(res.next()) {
                return true;
            }
        }catch(Exception e){System.out.println(e);}

        return false;
    }

    public boolean register(String accountNo,String pinNo, String contactNo) {
        try{
            String query="INSERT INTO clients "
                    + "(AccountNo, PinNo, ContactNo, UserLevel) "
                    + "VALUES " + "(?, ?, ?, ?)";

            PreparedStatement st=connection.prepareStatement(query);
            st.setInt(1, Integer.parseInt(accountNo));
            st.setInt(2, Integer.parseInt(pinNo));
            st.setInt(3, Integer.parseInt(contactNo));
            st.setInt(4, 1);

            st.executeUpdate();
            return true;
        }catch(Exception e){System.out.println(e);}

        return false;
    }

    public ArrayList<User> getUsers() throws SQLException {
        String query = "select * from clients where UserLevel=1";
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
