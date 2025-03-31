package org.example.vacation.application;

import org.example.vacation.domain.VacationCalculation;

import org.example.vacation.infrastructure.persistence.Mode;
import org.example.vacation.infrastructure.persistence.entity.VacationCalculationEntity;
import org.example.vacation.infrastructure.persistence.repository.VacationCalculationRepository;
import org.example.vacation.util.WorkingDaysCalculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class VacationCalculationService {
    private final VacationCalculationRepository repository;

    public VacationCalculationService(VacationCalculationRepository repository) {
        this.repository = repository;
    }

    public BigDecimal calculate(BigDecimal averageSalary, int vacationDays) {
        BigDecimal result = VacationCalculation.calculateVacationPay(averageSalary, vacationDays);
        repository.save(new VacationCalculationEntity(
                averageSalary,
                result,
                vacationDays,
                Mode.DAYS
        ));

        return result;
    }

    public BigDecimal calculate(BigDecimal averageSalary, LocalDate start, LocalDate end) {
        int workingDays = WorkingDaysCalculator.countWorkingDays(start, end);
        BigDecimal result = VacationCalculation.calculateVacationPay(averageSalary, workingDays);
        repository.save(new VacationCalculationEntity(
                averageSalary,
                result,
                workingDays,
                Mode.DATES
        ));

        return result;
    }
}