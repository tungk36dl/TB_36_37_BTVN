package com;

import java.util.Scanner;

public class bai2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String sNew = "";
//        for (int i = 0; i < s.length(); i++) {
//            char tmp = s.charAt(i);
//            if(i == 0 && s.charAt(i) >= 97 && s.charAt(i) <= 122){
//                tmp = ((char)(s.charAt(i) - 32)) ;
//            }
//            if(i > 0 && s.charAt(i-1) == 32 && s.charAt(i) >= 97 && s.charAt(i) <= 122){
//                tmp = ((char)(s.charAt(i) - 32)) ;
//            }
//            sNew += tmp;
//        }
//        System.out.println(sNew);
//    }

//        public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String sNew = "";
//        for (int i = 0; i < s.length(); i++) {
//            char tmp = s.charAt(i);
//            if(i == 0 && s.charAt(i) >= 97 && s.charAt(i) <= 122){
//                tmp = ((char)(s.charAt(i) - 32)) ;
//            }
//            if(i > 0 && s.charAt(i-1) == 32 && s.charAt(i) >= 97 && s.charAt(i) <= 122){
//                tmp = ((char)(s.charAt(i) - 32)) ;
//            }
//            sNew += tmp;
//        }
//        System.out.println(sNew);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        String sNew = "";



        for(String a:arr) {
            String tmp = a.substring(0, 1).toUpperCase();
            String tmp2 = a.substring(1);
            a = tmp + tmp2;
            sNew = sNew + a + " ";


        }


        System.out.println(sNew);


    }
}
