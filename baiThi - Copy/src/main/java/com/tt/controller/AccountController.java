package com.tt.controller;


import com.tt.entity.Account;
import com.tt.repository.AccountRepository;
import com.tt.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("account")
@Slf4j
public class AccountController {
    @Autowired
    AccountRepository accountRepo;

    @Autowired
    DepartmentRepository departmentRepo;

    @GetMapping("getAll")
    public List<Account> getAll(Model model,
                                Pageable pageable) {
        Page<Account> accountsPage = accountRepo.findAll(pageable);
        List<Account> accounts = accountsPage.toList();
        model.addAttribute("accounts", accounts);
        model.addAttribute("totalPage", accountsPage.getTotalPages());
        model.addAttribute("currentPage", pageable.getPageNumber());
        return accounts;
    }



    @DeleteMapping("account/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Account account = accountRepo.findById(id).orElse(null);
        if (account == null) {
            return new ResponseEntity<>("Không tìm thấy account với id = " + id, HttpStatus.BAD_REQUEST);
        }

        accountRepo.delete(account);
        return new ResponseEntity<>("Xóa account thành công", HttpStatus.OK);
    }
}
