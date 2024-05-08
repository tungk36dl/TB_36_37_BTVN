package com.tt.repository;

import com.tt.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByUsername(String username);

    @Query(value = "FROM Account WHERE username = :username")
    Account getDataByUsername(String username);
}
