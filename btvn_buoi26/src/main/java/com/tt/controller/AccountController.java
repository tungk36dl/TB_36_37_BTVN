package com.tt.controller;

import com.tt.entity.Account;
import com.tt.repository.AccountRepository;
import com.tt.req.AccountReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("account")
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
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account == null){
            log.error("\n Id khong ton tai!!!");
            return new ResponseEntity<>("Id khong ton tai", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Account co id: " + id + " la: " + account, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody AccountReq accountReq) {
        Account account = accountRepo.findByUsername(accountReq.getUsername());
        if(account == null) {
        System.out.println(accountReq);
            Account account1 = new Account();
            account1.setUsername(accountReq.getUsername());
            account1.setEmail(accountReq.getEmail());
            String password = new BCryptPasswordEncoder().encode(accountReq.getPassword());
            account1.setPassword(password);
            Date createAt = new Date();
            account1.setCreateAt(createAt);

            System.out.println(account1);
            accountRepo.save(account1);
            return new ResponseEntity<>("Luu account thanh cong", HttpStatus.OK);
        }
        log.error("\n Account da ton tai");
        return new ResponseEntity<>("Account da ton tai!!!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody AccountReq accountReq) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account == null) {
            log.error("\n Id khong ton tai!!!");
            return new ResponseEntity<>("Id khong ton tai", HttpStatus.BAD_REQUEST);
        }
        account.setUsername(accountReq.getUsername());
        account.setEmail(accountReq.getEmail());
        String password = new BCryptPasswordEncoder().encode(accountReq.getPassword());
        account.setPassword(password);
        Date updateAt = new Date();
        account.setUpdateAt(updateAt);
        accountRepo.save(account);
        return new ResponseEntity<>("Cap nhat Account thanh cong", HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account == null) {
            log.error("\n Id khong ton tai!!!");
            return new ResponseEntity<>("Id khong ton tai!!", HttpStatus.BAD_REQUEST);
        }

        accountRepo.delete(account);
        return new ResponseEntity<>("Xoa account thanh cong", HttpStatus.OK);
    }
}
