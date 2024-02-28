package com.tt;

import java.util.Scanner;

public class btvn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu cua mang: ");
        int n = sc.nextInt();
        while (n < 1){
            System.out.println("So luong phan tu phai lon hon 0. Vui long nhap lai!!!!");
            n = sc.nextInt();
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu a[" + (i+1) + "] = ");
            arr[i] = sc.nextInt();
        }

        giaiBT baiTap = new giaiBT();
        baiTap.xuatMang(arr, n);
        baiTap.maxArr(arr,n);
        baiTap.minArr(arr, n);
        baiTap.soNguyenTo(arr, n);
        baiTap.sapXep(arr, n);
    }
}
