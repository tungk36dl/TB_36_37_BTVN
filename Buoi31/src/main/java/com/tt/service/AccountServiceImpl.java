package com.tt.service;

import com.tt.entity.Account;
import com.tt.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    // c1: @Autowired
    private AccountRepository accountRepo;

    // c2:
    public AccountServiceImpl(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountRepo.findAll();
        return accounts;
    }

    @Override
    public Account findById(Integer id) {
        Account account = accountRepo.findById(id).orElse(null);
        return account;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.getDataByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException("Account not found");
        }
        return new User(username, account.getPassword(), Collections.emptyList());
    }
}
