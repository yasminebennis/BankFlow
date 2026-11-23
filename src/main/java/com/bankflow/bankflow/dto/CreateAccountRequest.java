
package com.bankflow.bankflow.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAccountRequest(

    @NotBlank
    String accountNumber,

    @NotBlank
    String ownerName,

    @NotNull
    @DecimalMin("0.00")
    BigDecimal balance

) {
}
