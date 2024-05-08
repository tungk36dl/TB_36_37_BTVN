package com.tt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientIndexController {

    @GetMapping
    public String clientIndex(Model model) {
        String page = "client-index";
        model.addAttribute("page", page);
        return "client-index";
    }

    @GetMapping("contact")
    public String clientContact(Model model) {
        String page = "client-contact";
        model.addAttribute("page", page);
        return "client-index";
    }

}
