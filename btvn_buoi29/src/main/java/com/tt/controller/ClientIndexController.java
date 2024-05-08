package com.tt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientIndexController {
    @GetMapping
    public String index() {
        return "client-index";
    }
}
