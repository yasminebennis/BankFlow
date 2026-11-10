package com.bankflow.bankflow.repository;

import com.bankflow.bankflow.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository
        extends JpaRepository<Account, Long> {
}
