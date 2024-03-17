package com.tn;

import java.sql.*;

public class Product {
    public void showData() {
        Connection con = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);
            System.out.println("Connect successfully!");

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM product");

            System.out.println("Id \tProduct_Name \tPrice \tAmount \tIs_Active \tTax_Percent \tCreated_Date \tUpdated_Date");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                boolean isActive = rs.getBoolean("is_active");
                int taxPercent = rs.getInt("tax_percent");
                Date createdDate = rs.getDate("created_date");
                Date updatedDate = rs.getDate("updated_date");

                System.out.println(id + " \t" + productName + " \t" + price + " \t" + amount + " \t" + isActive+ " \t" + taxPercent+ " \t" + createdDate+ " \t" + updatedDate);
            }
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }


// TÌm tên sản phẩm có chứa kí tự a
    public void yeuCau1() {
        Connection con = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);
            System.out.println("Connect successfully!");

            Statement stm = con.createStatement();


            System.out.println("Danh sach san pham co chu a la: ");
            ResultSet rs = stm.executeQuery("SELECT * FROM product WHERE product_name LIKE '%a%'");
//            stm.executeQuery("SELECT * FROM product WHERE product_name LIKE '%a%'");

            System.out.println("Id \tProduct_Name \tPrice \tAmount \tIs_Active \tTax_Percent \tCreated_Date \tUpdated_Date");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                boolean isActive = rs.getBoolean("is_active");
                int taxPercent = rs.getInt("tax_percent");
                Date createdDate = rs.getDate("created_date");
                Date updatedDate = rs.getDate("updated_date");

                System.out.println(id + " \t" + productName + " \t" + price + " \t" + amount + " \t" + isActive+ " \t" + taxPercent+ " \t" + createdDate+ " \t" + updatedDate);
            }
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    // Tìm những sản phảm có tên bắt đầu bằng kí tự b
    public void yeuCau2() {
        Connection con = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);
            System.out.println("Connect successfully!");

            Statement stm = con.createStatement();


            System.out.println("Danh sach san pham bat dau bang chu b: ");
            ResultSet rs = stm.executeQuery("SELECT * FROM product WHERE product_name LIKE 'b%'");
//            stm.executeQuery("SELECT * FROM product WHERE product_name LIKE '%a%'");

            System.out.println("Id \tProduct_Name \tPrice \tAmount \tIs_Active \tTax_Percent \tCreated_Date \tUpdated_Date");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                boolean isActive = rs.getBoolean("is_active");
                int taxPercent = rs.getInt("tax_percent");
                Date createdDate = rs.getDate("created_date");
                Date updatedDate = rs.getDate("updated_date");

                System.out.println(id + " \t" + productName + " \t" + price + " \t" + amount + " \t" + isActive+ " \t" + taxPercent+ " \t" + createdDate+ " \t" + updatedDate);
            }
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    // Tìmten san pham co ki gan cuoi la chu a
    public void yeuCau3() {
        Connection con = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);
            System.out.println("Connect successfully!");

            Statement stm = con.createStatement();


            System.out.println("Danh sach san pham co ki tu gan cuoi la chu a la: ");
            ResultSet rs = stm.executeQuery("SELECT * FROM product WHERE product_name LIKE '%a_'");
//            stm.executeQuery("SELECT * FROM product WHERE product_name LIKE '%a%'");

            System.out.println("Id \tProduct_Name \tPrice \tAmount \tIs_Active \tTax_Percent \tCreated_Date \tUpdated_Date");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                boolean isActive = rs.getBoolean("is_active");
                int taxPercent = rs.getInt("tax_percent");
                Date createdDate = rs.getDate("created_date");
                Date updatedDate = rs.getDate("updated_date");

                System.out.println(id + " \t" + productName + " \t" + price + " \t" + amount + " \t" + isActive+ " \t" + taxPercent+ " \t" + createdDate+ " \t" + updatedDate);
            }
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    // Tim ra nhuwng sanr phẩm có giá tiền trên 30 và mức thuế dưới 15 phần trăm
    public void yeuCau4() {
        Connection con = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);
            System.out.println("Connect successfully!");

            Statement stm = con.createStatement();


            System.out.println("Danh sach san pham co gia tren 30 va muc thue duoi 15%: ");
            ResultSet rs = stm.executeQuery("SELECT * FROM product WHERE price > 30 AND tax_percent < 15");
//            stm.executeQuery("SELECT * FROM product WHERE product_name LIKE '%a%'");

            System.out.println("Id \tProduct_Name \tPrice \tAmount \tIs_Active \tTax_Percent \tCreated_Date \tUpdated_Date");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                boolean isActive = rs.getBoolean("is_active");
                int taxPercent = rs.getInt("tax_percent");
                Date createdDate = rs.getDate("created_date");
                Date updatedDate = rs.getDate("updated_date");

                System.out.println(id + " \t" + productName + " \t" + price + " \t" + amount + " \t" + isActive+ " \t" + taxPercent+ " \t" + createdDate+ " \t" + updatedDate);
            }
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    //Tìm ra những sản phẩm có ngày taọ trong năm 2021
    public void yeuCau5() {
        Connection con = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + CommonDB.DB_NAME, CommonDB.USER, CommonDB.PASSWORD);
            System.out.println("Connect successfully!");

            Statement stm = con.createStatement();


            System.out.println("Danh sach san pham co ngay tao trong nam 2021: ");
            ResultSet rs = stm.executeQuery("SELECT * FROM product WHERE created_date BETWEEN '2021-01-01' AND '2021-12-31'");
//            stm.executeQuery("SELECT * FROM product WHERE product_name LIKE '%a%'");

            System.out.println("Id \tProduct_Name \tPrice \tAmount \tIs_Active \tTax_Percent \tCreated_Date \tUpdated_Date");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                boolean isActive = rs.getBoolean("is_active");
                int taxPercent = rs.getInt("tax_percent");
                Date createdDate = rs.getDate("created_date");
                Date updatedDate = rs.getDate("updated_date");

                System.out.println(id + " \t" + productName + " \t" + price + " \t" + amount + " \t" + isActive+ " \t" + taxPercent+ " \t" + createdDate+ " \t" + updatedDate);
            }
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }




}
