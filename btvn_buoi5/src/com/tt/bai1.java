package com.tt;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
//        Bài toán: Viết chương trình nhập vào một mảng gồm n số nguyên và thực hiện các công việc sau:
//
//        1. Xuất các giá trị của mảng ra
//        2. Tìm min, max
//        3. Tìm các số nguyên tố có trong mảng
//        4. Sắp xếp mảng theo thứ tự tăng dần
//        Deadline: 6 tiếng truoc buổi học tiếp theo
//        Gửi lên git rồi gửi link cho thầy


        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so luong phan tu cua mang: ");
        int n = sc.nextInt();
        do{
            System.out.println("So luong phan tu phai lon hon 0. Vui long nhap lai!!!");
             n = sc.nextInt();
        }while (n<1);
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }

        //        1. Xuất các giá trị của mảng ra
        for (int i = 0; i < n; i++) {
            System.out.println("a[" + (i+1) + "] = " + arr[i]);
        }

        //        2. Tìm min, max
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Gia tri lon nhat cua mang la: " + max);
        System.out.println("Gia tri nho nhat cua mang la: " + min);

        //        3. Tìm các số nguyên tố có trong mảng
        System.out.print("Cac so nguyen to trong mang la: ");
        for (int i = 0; i < n; i++) {
            if(arr[i] < 2) {
                continue;
            }else if(arr[i] == 2){
                System.out.print(2 + " ");
            }else {
                boolean isExit = false;
                for (int j = 2; j < arr[i] ; j++) {
                    if (arr[i] % j == 0) {
                        isExit = true;
                    }
                }
                if(isExit == false) {
                    System.out.print(arr[i] + " ");
                }
            }
        }

        //        4. Sắp xếp mảng theo thứ tự tăng dần

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(" ");
        System.out.println("Mang sau khi duoc sap xep lai la: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
