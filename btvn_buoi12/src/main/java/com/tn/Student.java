package com.tn;

import java.sql.*;

public class Student {
    public void showData() {
        Connection con = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);
            System.out.println("Connect successfully!");

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM student");

            System.out.println("Id \tFullName \tAddress \tEmail \tBirthday");
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");

                System.out.println(id + " \t" + fullName + " \t" + address + " \t" + email + " \t" + birthday);
            }
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    public void insertData(String fullName, String address, String email, String birthday) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);

            Statement stm = con.createStatement();

//            ResultSet rs = stm.executeQuery("SELECT * FROM student");

            String sql = "INSERT INTO student (full_name, address, email, birthday) " + "value('" + fullName + "', '" + address +
                    "', '" + email + "', '" + birthday + "')";

            stm.executeUpdate(sql);

            System.out.println("Insert successfull");

        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    public void deleteData(int id) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);

            Statement stm = con.createStatement();

//            ResultSet rs = stm.executeQuery("SELECT * FROM student");

            String sql = "DELETE FROM student WHERE id = " + id;

            stm.executeUpdate(sql);

            System.out.println("Delete successfull");

        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    public void updateData(int id, String fullName, String address, String email, String birthday) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);

            Statement stm = con.createStatement();

//            ResultSet rs = stm.executeQuery("SELECT * FROM student");

            String sql = "UPDATE student SET full_name = '" + fullName + "', address = '" + address + "' , email = '"+ email +
                     "' , birthday = '" + birthday + "' WHERE id = " + id;

            stm.executeUpdate(sql);

            System.out.println("Update successfull");

        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }
}
