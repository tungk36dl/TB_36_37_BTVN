package com.tn;

import java.util.Scanner;

public class ProgramWithProduct {
    public static void main(String[] args) {
        System.out.println("**** Chon yeu cau ****");
        System.out.println("0. Hien thi danh sach san pham");
        System.out.println("1. Tìm tên sản phẩm có chứa chữ 'a'");
        System.out.println("2. TÌm tên sản phẩm bắt đầu bằng chữ 'b'");
        System.out.println("3. TÌm tên sản phẩm có kí tự gần cuối là chữ 'a'");
        System.out.println("4. Tìm ra những sản phẩm có già tiền trên 50 và có mức thuế dưới 15%");
        System.out.println("5. Tìm những sản phẩm có ngày tạo trong năm 2021");
        System.out.println("6. Dung lai");

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap yeu cau can thuc hien: ");
        int n = sc.nextInt();
//        do {
//            if(n > 5 || n < 0) {
//                System.out.println("Ban phai nhap trong khoang tu 1 - 4 !!!");
//                n = sc.nextInt();
//            }
//        }while (n > 5 || n < 0);
//
//
//        Product product1 = new Product();
//
//        switch (n) {
//            case 0 :
//                System.out.println("thuc hien yeu cau 0 : ");
//                product1.showData();
//                break;
//            case 1 :
//                System.out.println("thuc hien yeu cau 1 : ");
//                product1.yeuCau1();
//                break;
//            case 2 :
////                System.out.println("thuc hien yeu cau 2 : ");
//                product1.yeuCau2();
//                break;
//            case 3 :
////                System.out.println("thuc hien yeu cau 3 : ");
//                product1.yeuCau3();
//                break;
//            case 4 :
////                System.out.println("thuc hien yeu cau 4 : ");
//                product1.yeuCau4();
//                break;
//            case 5 :
////                System.out.println("thuc hien yeu cau 5 : ");
//                product1.yeuCau5();
//                break;
//        }

        while (n != 6){
            do {
                if(n > 6 || n < 0) {
                    System.out.println("Ban phai nhap trong khoang tu 0 - 6 !!!");
                    n = sc.nextInt();
                }
            }while (n > 6 || n < 0);


            Product product1 = new Product();

            switch (n) {
                case 0 :
                    System.out.println("thuc hien yeu cau 0 : ");
                    product1.showData();
                    break;
                case 1 :
                    System.out.println("thuc hien yeu cau 1 : ");
                    product1.yeuCau1();
                    break;
                case 2 :
//                System.out.println("thuc hien yeu cau 2 : ");
                    product1.yeuCau2();
                    break;
                case 3 :
//                System.out.println("thuc hien yeu cau 3 : ");
                    product1.yeuCau3();
                    break;
                case 4 :
//                System.out.println("thuc hien yeu cau 4 : ");
                    product1.yeuCau4();
                    break;
                case 5 :
//                System.out.println("thuc hien yeu cau 5 : ");
                    product1.yeuCau5();
                    break;
                case 6 :
                    System.out.println("Chuong trinh dung lai!!!");
            }

            if(n >= 0 && n < 6) {
                System.out.println("Moi ban nhap yeu cau tiep theo");
                n = sc.nextInt();
            }
        }


    }
}
