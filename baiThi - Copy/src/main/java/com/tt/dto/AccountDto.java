package com.tt.dto;

import com.tt.entity.Department;
import lombok.Data;

@Data
public class AccountDto {

    private Integer id;

    private String username;

    private String password;

    private String fullName;

    private String address;

    private String departmentName;
}
