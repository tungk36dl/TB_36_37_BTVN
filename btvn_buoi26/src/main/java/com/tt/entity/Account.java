package com.tt.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private Date createAt;

    private Date updateAt;

}
