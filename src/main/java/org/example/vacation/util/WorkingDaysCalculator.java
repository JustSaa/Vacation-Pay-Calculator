package org.example.vacation.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class WorkingDaysCalculator {

    private static final Set<LocalDate> HOLIDAYS = new HashSet<>();

    static {
        HOLIDAYS.add(LocalDate.of(2024, 1, 1));
        HOLIDAYS.add(LocalDate.of(2024, 1, 7));
        HOLIDAYS.add(LocalDate.of(2024, 5, 1));
        HOLIDAYS.add(LocalDate.of(2024, 5, 9));
    }

    public static int countWorkingDays(LocalDate start, LocalDate end) {
        int workingDays = 0;
        LocalDate date = start;

        while (!date.isAfter(end)) {
            boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY
                    || date.getDayOfWeek() == DayOfWeek.SUNDAY;

            boolean isHoliday = HOLIDAYS.contains(date);

            if (!isWeekend && !isHoliday) {
                workingDays++;
            }

            date = date.plusDays(1);
        }

        return workingDays;
    }
}