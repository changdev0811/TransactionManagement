package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    String sql="select *from clients where AccountNo=? and PinNo=?";
    String url = "jdbc:mysql://127.0.0.1:3306/bank";
    String user = "root";
    String password = "";

    public boolean check(String accountNo,String pinNo) {
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con= DriverManager.getConnection( url, user, password );
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(accountNo));
            st.setInt(2, Integer.parseInt(pinNo));
            ResultSet rs=st.executeQuery();
            if(rs.next()) {
                return true;
            }
        }catch(Exception e){System.out.println(e);}

        return false;
    }
}
