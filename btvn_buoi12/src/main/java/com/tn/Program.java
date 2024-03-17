//package com.tn;
//
////import java.sql.Date;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Program {
//    public static void main(String[] args)  {
//        System.out.println("**** Student Management ****");
//        System.out.println("1. Show All Student");
//        System.out.println("2. Insert A Student");
//        System.out.println("3. Update A Student");
//        System.out.println("4. Delete A Student");
//        System.out.println("5. Exit");
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập giá trị n:");
//        int n = 1;
//        try {
//            n = sc.nextInt();
//            int b = Integer.parseInt("pp");
//        }catch (InputMismatchException ex) {
//            System.out.println("Enter data fail");
//            System.out.println(ex);
//        }catch (NumberFormatException ex) {
//            System.out.println("Enter data fail");
//            System.out.println(ex);
//        }
//
//
//        Student student1 = new Student();
//        if (n == 1) {
//            System.out.println("Show");
//
//            student1.showData();
//        } else if (n == 2) {
//            sc = new Scanner(System.in);
//            System.out.println("Nhap ho va ten");
//            String fullName = sc.nextLine();
//            System.out.println("Nhap dia chi");
//            String address = sc.nextLine();
//            System.out.println("Nhap email");
//            String email = sc.nextLine();
//            System.out.println("Nhap ngay sinh dung dinh dang: yyyy-mm-dd");
//            String birthday = sc.nextLine();
//
//
//            student1.insertData(fullName, address, email, birthday);
//        } else if (n == 3) {
//
//            sc = new Scanner(System.in);
//            student1.showData();
//            System.out.println("ENter id to update");
//            int id = sc.nextInt();
//
//            sc = new Scanner(System.in);
//            System.out.println("Nhap ho va ten");
//            String fullName = sc.nextLine();
//            System.out.println("Nhap dia chi");
//            String address = sc.nextLine();
//            System.out.println("Nhap email");
//            String email = sc.nextLine();
//            System.out.println("Nhap ngay sinh dung dinh dang: yyyy-mm-dd");
//            String birthday = sc.nextLine();
//
//            student1.updateData(id, fullName, address, email, birthday);
//
//
//        } else if (n == 4) {
//            student1.showData();
//
//            System.out.println("Nhap id can xoa");
//
//            sc = new Scanner(System.in);
//            int id = sc.nextInt();
//
//            student1.deleteData(id);
//        }
//
//
//    }
//}


