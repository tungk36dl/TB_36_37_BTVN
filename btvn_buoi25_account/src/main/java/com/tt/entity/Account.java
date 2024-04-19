package com.tt.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Accounts2")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

//    private String email;

}
