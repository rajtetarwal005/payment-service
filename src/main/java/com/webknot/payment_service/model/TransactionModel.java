package com.webknot.payment_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Long userId;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType; // CARD / QR

    private String status; // SUCCESS / FAILED / PENDING
    private LocalDateTime createdAt;
}
