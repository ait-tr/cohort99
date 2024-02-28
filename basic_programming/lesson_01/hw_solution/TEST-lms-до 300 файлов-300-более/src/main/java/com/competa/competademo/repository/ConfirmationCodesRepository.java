package com.competa.competademo.repository;

import com.competa.competademo.entity.ConfirmationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ConfirmationCodesRepository extends JpaRepository<ConfirmationCode, Long> {
    Optional<ConfirmationCode> findByCodeAndExpireTimeAfter(String code, LocalDateTime now);
}
