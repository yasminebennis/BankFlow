package com.bankflow.bankflow.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleAccountAlreadyExists(
            AccountAlreadyExistsException ex) {

        Map<String, String> error = Map.of(
            "error", "ACCOUNT_ALREADY_EXISTS",
            "message", ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }
}
