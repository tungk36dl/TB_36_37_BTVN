package com.tt.controller;

import com.tt.entity.Account;
import com.tt.repository.AccountRepository;
import com.tt.req.AccountReq;
import com.tt.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("account")
@Slf4j
public class AccountController {

    private AccountRepository accountRepo;

    private AccountService accountService;

    public AccountController(AccountRepository accountRepo, AccountService accountService) {
        this.accountRepo = accountRepo;
        this.accountService = accountService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Account> accounts = accountService.getAll();
        System.out.println(accounts);

        model.addAttribute("accounts", accounts);
        return "account-list";
//        return "test";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account == null) {
            System.out.println("Not fount Account with id = " + id);
        }

        accountRepo.delete(account);
        return "redirect:/account";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
//        Optional<Account> opAccount = accountRepo.findById(id);
        Account opAccount = accountRepo.findById(id).orElse(null);
        if(opAccount == null) {
            System.out.println("Not found account with id = " + id);
        }

        model.addAttribute("opAccount", opAccount);
        System.out.println("opAccount" + opAccount);
        return "edit-account";
    }

    @PostMapping("edit/{id}")
    public String edit(@PathVariable Integer id,
                        @RequestBody AccountReq accountReq) {

        System.out.println("accountReq: " + accountReq );

        Account opAccount = accountRepo.findById(id).orElse(null);
        System.out.println("opAccount: " + opAccount );

        opAccount.setUsername(accountReq.getUsername());
        opAccount.setEmail(accountReq.getEmail());
        opAccount.setPassword(accountReq.getPassword());
        accountRepo.save(opAccount);
        return "redirect:/account";
    }

}
