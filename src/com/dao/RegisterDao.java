package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDao {
    String sql="INSERT INTO clients "
            + "(AccountNo, PinNo, ContactNo, UserLevel) "
            + "VALUES " + "(?, ?, ?, ?)";
    String url = "jdbc:mysql://127.0.0.1:3306/bank";
    String user = "root";
    String password = "";

    public boolean register(String accountNo,String pinNo, String contactNo) {
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con= DriverManager.getConnection( url, user, password );
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(accountNo));
            st.setInt(2, Integer.parseInt(pinNo));
            st.setInt(3, Integer.parseInt(contactNo));
            st.setInt(4, 1);

            st.executeUpdate();

        }catch(Exception e){System.out.println(e);}

        return false;
    }
}
