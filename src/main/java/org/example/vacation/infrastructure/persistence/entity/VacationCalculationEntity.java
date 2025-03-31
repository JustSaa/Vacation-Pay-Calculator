package org.example.vacation.infrastructure.persistence.entity;

import org.example.vacation.infrastructure.persistence.Mode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vacation_calculations")
public class VacationCalculationEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private BigDecimal averageSalary;

    @Column(nullable = false)
    private BigDecimal calculatedAmount;

    @Column(nullable = false)
    private int daysCounted;

    @Enumerated(EnumType.STRING)
    private Mode mode;

    @Column(nullable = false)
    private LocalDateTime calculationDate;

    public VacationCalculationEntity() {
    }

    public VacationCalculationEntity(BigDecimal averageSalary, BigDecimal calculatedAmount, int daysCounted, Mode mode) {
        this.averageSalary = averageSalary;
        this.calculatedAmount = calculatedAmount;
        this.daysCounted = daysCounted;
        this.mode = mode;
        this.calculationDate = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(BigDecimal calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    public int getDaysCounted() {
        return daysCounted;
    }

    public void setDaysCounted(int daysCounted) {
        this.daysCounted = daysCounted;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public LocalDateTime getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(LocalDateTime calculationDate) {
        this.calculationDate = calculationDate;
    }
}