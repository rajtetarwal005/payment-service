package com.webknot.payment_service.service;

import com.webknot.payment_service.model.TransactionModel;
import com.webknot.payment_service.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Fix: Add this method to avoid "Cannot resolve method" error
    public List<TransactionModel> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionModel processTransaction(TransactionModel transaction) {
        return transactionRepository.save(transaction);
    }

    public List<TransactionModel> getUserTransactions(Long userId) {
        return transactionRepository.findByUserId(userId);
    }
}
