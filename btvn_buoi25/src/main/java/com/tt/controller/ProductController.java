package com.tt.controller;


import com.tt.entity.Product;
import com.tt.repository.ProductRepository;
import com.tt.req.ProductReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("getAll")
    public List<Product> getAll() {
        List<Product> products = productRepo.findAll();
        System.out.println(products);
        return products;
    }

    @GetMapping ("getAll/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Product product = productRepo.findById(id).orElse(null);
        if(product != null) {
            System.out.println(product);
            return new ResponseEntity<>( "San pham cos id : " + id + " la: " + product , HttpStatus.OK);
        }
        log.error("\n Khong tim thay id : " + id);
        return new ResponseEntity<>("KHong cos san pham cos id : " + id , HttpStatus.BAD_REQUEST);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody ProductReq productReq) {
        Product product = new Product();
        product.setProductName(productReq.getProductName());
        product.setPrice(productReq.getPrice());
        productRepo.save(product);
        return new ResponseEntity<>("Luu san pham moi thanh cong", HttpStatus.OK);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody ProductReq productReq) {
        Product product = productRepo.findById(id).orElse(null);
        if(product != null){
            product.setProductName(productReq.getProductName());
            product.setPrice(productReq.getPrice());
            productRepo.save(product);
            return new ResponseEntity<>("Sua san pham moi thanh cong", HttpStatus.OK);
        }
        log.error("\n Khong tim thay id : " + id);
        return new ResponseEntity<>("Khong tim thay id", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Product product = productRepo.findById(id).orElse(null);
        if(product != null) {
            productRepo.delete(product);
            return new ResponseEntity<>("Xoa san pham  thanh cong", HttpStatus.OK);
        }
        log.error("\n Khong tim thay id : " + id);
        return new ResponseEntity<>("Khong tim thay id!!!", HttpStatus.BAD_REQUEST);

    }
}
