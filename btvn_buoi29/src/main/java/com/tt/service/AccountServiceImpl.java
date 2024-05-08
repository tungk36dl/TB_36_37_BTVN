package com.tt.service;

import com.tt.entity.Account;
import com.tt.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountRepo.findAll();
        return accounts;
    }
}
