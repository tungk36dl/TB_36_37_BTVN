package com.tt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @GetMapping("product")
    public String getAll(Model model) {
        String page = "product-list-client";
        model.addAttribute("page", page);
        return "client-index";
    }
}
