package org.example.vacation.application;

import org.example.vacation.domain.VacationCalculation;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class VacationCalculationService {

    public BigDecimal calculate(BigDecimal averageSalary, int vacationDays) {
        return VacationCalculation.calculateVacationPay(averageSalary, vacationDays);
    }

    public BigDecimal calculate(BigDecimal averageSalary, LocalDate start, LocalDate end) {
        long totalDays = ChronoUnit.DAYS.between(start, end) + 1;
        return VacationCalculation.calculateVacationPay(averageSalary, (int) totalDays);
    }
}