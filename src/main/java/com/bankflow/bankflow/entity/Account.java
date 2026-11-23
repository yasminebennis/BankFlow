package com.bankflow.bankflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance;


    public Long getId() {
        return id;
    }

   public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}