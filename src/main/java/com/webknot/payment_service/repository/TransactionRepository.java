package com.webknot.payment_service.repository;

import com.webknot.payment_service.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
    List<TransactionModel> findByUserId(Long userId);
}
