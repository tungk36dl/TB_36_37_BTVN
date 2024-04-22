package com.tt.controller;



import com.tt.entity.Product;
import com.tt.repository.ProductRepository;
import com.tt.req.ProductReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("getAll")
    public List<Product> getAll() {
        List<Product> products = productRepo.findAll();
        System.out.println(products);
        return products;
    }

    @GetMapping("getById")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Product product = productRepo.findById(id).orElse(null);
        if(product == null){
            log.error("\n Id khong ton tai!!!");
            return new ResponseEntity<>("Id khong ton tai", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Product co id: " + id + " la: " + product, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody ProductReq productReq) {
         Product product = productRepo.findByProductName(productReq.getProductName());
        if(product == null) {
            Product product1 = new Product();
            product1.setProductName(productReq.getProductName());
            product1.setPrice(productReq.getPrice());

            Date createAt = new Date();
            product1.setCreateAt(createAt);

            productRepo.save(product1);
            return new ResponseEntity<>("Luu product thanh cong", HttpStatus.OK);
        }
        log.error("\n Product da ton tai");
        return new ResponseEntity<>("Product da ton tai!!!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<?> save(@PathVariable Integer id, @RequestBody ProductReq productReq) {
        Product product = productRepo.findById(id).orElse(null);
        if(product != null) {

            product.setProductName(productReq.getProductName());
            product.setPrice(productReq.getPrice());

            Date updateAt = new Date();
            product.setUpdateAt(updateAt);

            productRepo.save(product);
            return new ResponseEntity<>("Edit san pham thanh cong", HttpStatus.OK);
        }
        log.error("\n Id ko ton tai");
        return new ResponseEntity<>("Id khong ton tai", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Product product = productRepo.findById(id).orElse(null);
        if(product == null) {
            log.error("\n Id khong ton tai!!!");
            return new ResponseEntity<>("Id khong ton tai!!", HttpStatus.BAD_REQUEST);
        }

        productRepo.delete(product);
        return new ResponseEntity<>("Xoa product thanh cong", HttpStatus.OK);
    }

}
