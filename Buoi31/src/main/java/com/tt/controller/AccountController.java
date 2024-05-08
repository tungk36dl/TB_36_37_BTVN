package com.tt.controller;


import com.tt.entity.Account;
import com.tt.repository.AccountRepository;
import com.tt.service.AccountService;
import com.tt.service.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("account")
@Slf4j
public class AccountController {

    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepo;

    public AccountController(AccountService accountService,
                                AccountRepository accountRepo) {
        this.accountService = accountService;
        this.accountRepo = accountRepo;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Account> accounts = accountService.getAll();
        System.out.println(accounts);

        model.addAttribute("accounts", accounts);
        return "account-list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id,
                         Model model){

        Optional<Account> opAccount = accountRepo.findById(id);
        if(opAccount.isEmpty()) {
            System.out.println("Not found Account with id = " + id);
        }
        accountRepo.deleteById(id);



//        return "account-list";
        return "redirect:/account";
    }


}
