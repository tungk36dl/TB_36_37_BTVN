package com.tt;

public class giaiBT {
    public static void xuatMang(int[] arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.println("Phan tu arr[" + (i+1) + "] = " + arr[i]);
        }
    }

    public static void maxArr(int[] arr, int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Phan tu lon nhat trong mang la: " + max);
    }

    public static void minArr(int[] arr, int n) {
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Phan tu nho nhat trong mang la: " + min);
    }

    public static void soNguyenTo(int[] arr, int n){
        System.out.print("Cac so nguyen to trong mang la: ");
        for (int i = 0; i < n; i++) {
            if(arr[i] < 1){

            }else if(arr[i] == 2) {
                System.out.print(arr[i] + " ");
            }else {
                boolean isExit = false;
                for (int j = 2; j < arr[i] ; j++) {
                    if(arr[i] % j == 0){
                        isExit = true;
                    }
                }
                if(!isExit) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
        System.out.println(" ");
    }

    public static void sapXep(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        System.out.print("Mang sau khi duoc sap xep tang dan la: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
