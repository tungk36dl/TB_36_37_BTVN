package com.tt.Controller;

import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("admin/account")
    public String getAll() {
        return "account-list";
    }

    @GetMapping("login")
    public  String login(HttpSessionRequiredException )

}
