package com.tt.req;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryReq {
    private String categoryName;

    private Date createAt;
}
