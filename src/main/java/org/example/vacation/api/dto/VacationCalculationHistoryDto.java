package org.example.vacation.api.dto;

import org.example.vacation.infrastructure.persistence.Mode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class VacationCalculationHistoryDto {

    private UUID id;
    private BigDecimal averageSalary;
    private BigDecimal calculatedAmount;
    private int daysCounted;
    private Mode mode;
    private LocalDateTime calculationDate;

    public VacationCalculationHistoryDto(UUID id, BigDecimal averageSalary, BigDecimal calculatedAmount,
                                         int daysCounted, Mode mode, LocalDateTime calculationDate) {
        this.id = id;
        this.averageSalary = averageSalary;
        this.calculatedAmount = calculatedAmount;
        this.daysCounted = daysCounted;
        this.mode = mode;
        this.calculationDate = calculationDate;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public int getDaysCounted() {
        return daysCounted;
    }

    public Mode getMode() {
        return mode;
    }

    public LocalDateTime getCalculationDate() {
        return calculationDate;
    }
}