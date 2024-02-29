package com.tt;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
//        btvn: Bài 1: Tính S(n) = 1 + 2 + 3 + … + n
//        Input: 1 số n
//        Ouput: Tổng (số nguyên)
//        Bài 2: Tính S(n) = 1^2 + 2^2 + … + n^2
//        Bài 3: Tính S(n) = 1 + ½ + 1/3 + … + 1/n
//        Deadline: trước 6 tiêng của buổi tiếp theo

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen duong n = ");
        int n = sc.nextInt();
        while (n<=0) {
            System.out.println("n phai la so nguyen duong. Vui long nhap lai!!!!");
             n = sc.nextInt();
        }
        tinhToan result = new tinhToan();
        System.out.print("Tong day so tu 1 den " + n + " la: ");
        int result1 = result.tinhTong(n);
        System.out.println(result1);

        System.out.print("Tong say so binh phuong tu 1 den " + n + " la: ");
        long result2 = result.tinhTongBinhPhuong(n);
        System.out.println(result2);

        System.out.print("Tong day so thap phan tu 1 den 1/" + n + " la: ");
        double result3 = result.tinhTongThapPhan(n);
        System.out.println(result3);

    }
}
