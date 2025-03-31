package org.example.vacation.application;

import org.example.vacation.domain.VacationCalculation;

import org.example.vacation.util.WorkingDaysCalculator;
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
        int workingDays = WorkingDaysCalculator.countWorkingDays(start, end);
        return VacationCalculation.calculateVacationPay(averageSalary, workingDays);
    }
}