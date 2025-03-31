package org.example.vacation.api.dto;

import java.math.BigDecimal;

public class VacationResponseDto {

    private BigDecimal amount;

    public VacationResponseDto(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}