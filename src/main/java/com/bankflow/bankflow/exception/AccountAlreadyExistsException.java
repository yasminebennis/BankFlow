package com.bankflow.bankflow.exception;

public class AccountAlreadyExistsException
        extends RuntimeException {

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
