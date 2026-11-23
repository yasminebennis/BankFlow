
package com.bankflow.bankflow.service;

import com.bankflow.bankflow.repository.AccountRepository;
import com.bankflow.bankflow.entity.Account;
import com.bankflow.bankflow.dto.CreateAccountRequest;
import com.bankflow.bankflow.dto.AccountResponse;
import com.bankflow.bankflow.exception.AccountAlreadyExistsException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountResponse> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream()
                .map(this::toResponse)
                .toList();
    }

    public AccountResponse createAccount(CreateAccountRequest request) {

        if (accountRepository.existsByAccountNumber(request.accountNumber())) {
            throw new AccountAlreadyExistsException(
                "Account number already exists: " + request.accountNumber()
            );
        }

        Account account = new Account();

        account.setAccountNumber(request.accountNumber());
        account.setOwnerName(request.ownerName());
        account.setBalance(request.balance());

        Account savedAccount = accountRepository.save(account);

        return toResponse(savedAccount);
    }

    public AccountResponse toResponse(Account account) {

        return new AccountResponse(
            account.getId(),
            account.getAccountNumber(),
            account.getOwnerName(),
            account.getBalance()
        );
    }

}
