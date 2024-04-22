package com.tt.service;

import com.tt.entity.Account;
import com.tt.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username: ");
        System.out.println(username);
        Account account = accountRepo.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException("Not Found Account");
        }
        return new User(username, account.getPassword(), Collections.emptyList());
    }

}
