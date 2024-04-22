package com.tt.controller;

import com.tt.entity.Category;
import com.tt.repository.CategoryRepository;
import com.tt.req.CategoryReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("getAll")
    public List<Category> getAll() {
        List<Category> categories = categoryRepo.findAll();
        System.out.println(categories);
        return categories;
    }

    @GetMapping("getById")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Category category = categoryRepo.findById(id).orElse(null);
        if(category == null) {
            log.error("Id ko ton tai!!!");
            return new ResponseEntity<>("Id khong ton tai", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Category cua id: " + id + " la : " + category, HttpStatus.OK);
    }


    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody CategoryReq categoryReq) {
        Category category = categoryRepo.findByCategoryName(categoryReq.getCategoryName());
        if(category == null) {
            Category category1 = new Category();
            category1.setCategoryName(categoryReq.getCategoryName());

            Date ceateAt = new Date();
            category1.setCreateAt(ceateAt);
            categoryRepo.save(category1);
            return new ResponseEntity<>("Save category thanh cong!!", HttpStatus.OK);
        }
        log.error("Category da ton tai");
        return new ResponseEntity<>("Category da ton tai!!!", HttpStatus.BAD_REQUEST);
    }
}
