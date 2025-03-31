package org.example.vacation.api;

import org.example.vacation.application.VacationCalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VacationController.class)
class VacationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacationCalculationService calculationService;

    @Test
    void shouldReturnVacationPayByDays() throws Exception {
        when(calculationService.calculate(new BigDecimal("60000"), 10))
                .thenReturn(new BigDecimal("20460.07"));

        mockMvc.perform(get("/calculate")
                        .param("averageSalary", "60000")
                        .param("vacationDays", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(20460.07));
    }

    @Test
    void shouldReturnVacationPayByDates() throws Exception {
        LocalDate start = LocalDate.of(2024, 5, 1);
        LocalDate end = LocalDate.of(2024, 5, 10);

        when(calculationService.calculate(new BigDecimal("60000"), start, end))
                .thenReturn(new BigDecimal("20460.07"));

        mockMvc.perform(get("/calculate")
                        .param("averageSalary", "60000")
                        .param("startDate", "2024-05-01")
                        .param("endDate", "2024-05-10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(20460.07));
    }

    @Test
    void shouldReturnBadRequestIfMissingParams() throws Exception {
        mockMvc.perform(get("/calculate")
                        .param("averageSalary", "60000"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestIfStartDateAfterEndDate() throws Exception {
        mockMvc.perform(get("/calculate")
                        .param("averageSalary", "60000")
                        .param("startDate", "2024-06-01")
                        .param("endDate", "2024-05-01"))
                .andExpect(status().isBadRequest());
    }
}