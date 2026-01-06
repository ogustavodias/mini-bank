package com.mini.bank.models.transfer;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransferRequestDto(
      @NotNull UUID payerId,
      @NotNull UUID receiverId,
      @NotNull @Min(value = 1) BigDecimal amount) {
}
