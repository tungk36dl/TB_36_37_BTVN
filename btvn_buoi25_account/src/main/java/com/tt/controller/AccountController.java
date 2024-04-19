package com.tt.controller;

import com.tt.entity.Account;
import com.tt.repository.AccountRepository;
import com.tt.req.AccountReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountRepository accountRepo;

    @GetMapping("getAll")
    public List<Account> getAll() {
        List<Account> accounts = accountRepo.findAll();
        System.out.println(accounts);
        return accounts;
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getBYId(@PathVariable Integer id) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account == null) {
            System.out.println(account);
            return new ResponseEntity<>("Acount voi id: " + id + "la: " + account, HttpStatus.OK);
        }
        log.error("\n Khong tim thay id: " + id);
        return new ResponseEntity<>("KHong tim thay id: " + id, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id,
                                  @RequestBody AccountReq accountReq) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account != null){
            account.setUserName(accountReq.getUserName());
            account.setPassword(accountReq.getPassword());
            accountRepo.save(account);
            return new ResponseEntity<>("Edit thanh cong", HttpStatus.OK);
        }

        log.error("\n Khong tim thay id");
        return new ResponseEntity<>("Khong tim thay id", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody AccountReq accountReq) {
        Account account = accountRepo.findByUserName(accountReq.getUserName());
        if(account == null) {
            Account account1 = new Account();
            account1.setUserName(accountReq.getUserName());
            account1.setPassword(accountReq.getPassword());
            accountRepo.save(account1);
            return new ResponseEntity<>("Save thanh cong", HttpStatus.OK);
        }
        log.error("\n Account đa ton tai!!!");
        return new ResponseEntity<>("Account đã tồn tại !!!!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping ("delete")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account == null) {
            log.error("\n Khong tim thay id");
            return new ResponseEntity<>("Khong tim thay id: " + id, HttpStatus.BAD_REQUEST);
        }
        accountRepo.delete(account);
        return new ResponseEntity<>("Delete account successfully", HttpStatus.OK);
    }
}
