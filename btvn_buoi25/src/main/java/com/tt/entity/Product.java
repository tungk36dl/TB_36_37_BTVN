package com.tt.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Product2")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;

    private Integer price;
}
