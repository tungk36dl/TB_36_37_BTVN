package com.tt.req;

import lombok.Data;

import java.util.Date;

@Data
public class ProductReq {
    private String productName;

    private Integer price;

    private Date createAt;
}
