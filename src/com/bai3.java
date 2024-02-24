package com;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao 1 chuoi: ");
        String s = sc.nextLine();
        String sNew1 = s.replace("n", "a");
        String sNew2 = sNew1.replace("g", "a");
        System.out.println("Chuoi sau khi thay doi la: " + sNew2);
    }



}
