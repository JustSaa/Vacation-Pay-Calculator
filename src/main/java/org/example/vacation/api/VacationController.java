package org.example.vacation.api;

import org.example.vacation.api.dto.VacationCalculationHistoryDto;
import org.example.vacation.api.dto.VacationRequestDto;
import org.example.vacation.api.dto.VacationResponseDto;
import org.example.vacation.application.VacationCalculationService;

import org.example.vacation.infrastructure.persistence.entity.VacationCalculationEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calculate")
@Validated
public class VacationController {

    private final VacationCalculationService calculationService;

    public VacationController(VacationCalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping
    public ResponseEntity<VacationResponseDto> calculateVacation(@Valid VacationRequestDto request) {
        BigDecimal amount;

        if (request.getStartDate() != null && request.getEndDate() != null) {
            LocalDate start = request.getStartDate();
            LocalDate end = request.getEndDate();

            if (start.isAfter(end)) {
                return ResponseEntity.badRequest().build();
            }
            amount = calculationService.calculate(request.getAverageSalary(), start, end);
        } else if (request.getVacationDays() != null) {
            amount = calculationService.calculate(request.getAverageSalary(), request.getVacationDays());
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new VacationResponseDto(amount));
    }

    @GetMapping("/history")
    public ResponseEntity<List<VacationCalculationHistoryDto>> getHistory() {
        List<VacationCalculationEntity> entities = calculationService.getAll();

        List<VacationCalculationHistoryDto> response = entities.stream()
                .map(e -> new VacationCalculationHistoryDto(
                        e.getId(),
                        e.getAverageSalary(),
                        e.getCalculatedAmount(),
                        e.getDaysCounted(),
                        e.getMode(),
                        e.getCalculationDate()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}