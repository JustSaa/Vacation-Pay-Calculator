package org.example.vacation.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VacationCalculation {

    private static final BigDecimal AVERAGE_DAYS_IN_MONTH = BigDecimal.valueOf(29.3);

    public static BigDecimal calculateVacationPay(BigDecimal averageSalary, int vacationDays) {
        if (vacationDays <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal dailySalary = averageSalary
                .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP)
                .divide(AVERAGE_DAYS_IN_MONTH, 2, RoundingMode.HALF_UP);

        return dailySalary.multiply(BigDecimal.valueOf(vacationDays));
    }
}