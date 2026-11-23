package com.bankflow.bankflow.controller;

import com.bankflow.bankflow.service.AccountService;
import com.bankflow.bankflow.dto.CreateAccountRequest;
import com.bankflow.bankflow.dto.AccountResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    
    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(
            @Valid @RequestBody CreateAccountRequest request) {

        AccountResponse response = accountService.createAccount(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

}
