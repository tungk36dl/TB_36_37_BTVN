package com.tt.service;

import com.tt.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {

    // abstraact method, public access modifier
    List<Account> getAll();

    Account findById(Integer id);

}
