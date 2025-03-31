package org.example.vacation.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacationCalculationServiceTest {

    private final VacationCalculationService service = new VacationCalculationService();

    @Test
    void shouldCalculateByDaysCorrectly() {
        BigDecimal salary = new BigDecimal("60000");
        int days = 10;

        BigDecimal expected = salary
                .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(29.3), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(days));

        BigDecimal actual = service.calculate(salary, days);
        assertEquals(0, expected.compareTo(actual));
    }

    @Test
    void shouldCalculateByDateRangeExcludingWeekendsAndHolidays() {
        BigDecimal salary = new BigDecimal("60000");
        LocalDate start = LocalDate.of(2024, 5, 1);
        LocalDate end = LocalDate.of(2024, 5, 10);

        int expectedWorkingDays = 6;

        BigDecimal expected = salary
                .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(29.3), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(expectedWorkingDays));

        BigDecimal actual = service.calculate(salary, start, end);
        assertEquals(0, expected.compareTo(actual));
    }

    @Test
    void shouldReturnZeroForZeroDays() {
        BigDecimal salary = new BigDecimal("60000");
        int days = 0;

        BigDecimal actual = service.calculate(salary, days);
        assertEquals(BigDecimal.ZERO, actual);
    }
}