package com.tt;

import java.util.Scanner;

public class Person {
    public String name;
    public String gender;
    public String birthday;
    public String address;

//    public static Person(){
//
//    }

    public Person() {

    }

    public Person(String name, String gender, String birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        this.name = name;

        System.out.print("Nhap gioi tinh: ");
        String gender = sc.nextLine();
        this.gender = gender;

        System.out.print("Nhap ngay sinh: ");
        String birthday = sc.nextLine();
        this.birthday = birthday;

        System.out.print("Nhap dia chi: ");
        String address = sc.nextLine();
        this.address = address;

    }

    public void showInfo() {
        System.out.println("Ten: " + this.name);
        System.out.println("Gioi tinh: " + this.gender);
        System.out.println("Ngay sinh: " + this.birthday);
        System.out.println("Dia chi: " + this.address);
    }

}
