package org.example.vacation.infrastructure.persistence.repository;

import org.example.vacation.infrastructure.persistence.entity.VacationCalculationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VacationCalculationRepository extends JpaRepository<VacationCalculationEntity, UUID> {
}
