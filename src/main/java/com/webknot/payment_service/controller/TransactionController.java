package com.webknot.payment_service.controller;

import com.webknot.payment_service.model.TransactionModel;
import com.webknot.payment_service.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //  GET all transactions (Fix for 404 error)
    @GetMapping
    public List<TransactionModel> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    //  POST to make a payment
    @PostMapping("/pay")
    public TransactionModel makePayment(@RequestBody TransactionModel transaction) {
        return transactionService.processTransaction(transaction);
    }

    //  GET user transaction history
    @GetMapping("/history/{userId}")
    public List<TransactionModel> getUserTransactionHistory(@PathVariable Long userId) {
        return transactionService.getUserTransactions(userId);
    }
}
