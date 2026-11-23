package com.bankflow.bankflow.dto;

import java.math.BigDecimal;

public record AccountResponse(
    Long id,
    String accountNumber,
    String ownerName,
    BigDecimal balance
) {
}
