package com.tt;

public class tinhToan {

//    btvn: Bài 1: Tính S(n) = 1 + 2 + 3 + … + n
//    Input: 1 số n
//    Ouput: Tổng (số nguyên)
//    Bài 2: Tính S(n) = 1^2 + 2^2 + … + n^2
//    Bài 3: Tính S(n) = 1 + ½ + 1/3 + … + 1/n
//    Deadline: trước 6 tiêng của buổi tiếp theo

    public int tinhTong(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    //    Bài 2: Tính S(n) = 1^2 + 2^2 + … + n^2
    public long tinhTongBinhPhuong(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i*i;
        }
        return sum;
    }

    //    Bài 3: Tính S(n) = 1 + ½ + 1/3 + … + 1/n
    public double tinhTongThapPhan(int n) {
        double sum = 0.0;
        for(int i = 1; i<= n; i++) {
            double tmp = 1.0/i;
            sum += tmp;
        }
        return sum;
    }

}
