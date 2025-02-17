package com.webknot.payment_service.service;

import com.webknot.payment_service.model.PenaltyModel;
import com.webknot.payment_service.repository.PenaltyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyService {
    private final PenaltyRepository penaltyRepository;

    public PenaltyService(PenaltyRepository penaltyRepository) {
        this.penaltyRepository = penaltyRepository;
    }

    public PenaltyModel createPenalty(PenaltyModel penalty) {
        return penaltyRepository.save(penalty);
    }

    public List<PenaltyModel> getUnpaidPenalties(Long userId) {
        return penaltyRepository.findByUserIdAndStatus(userId, "UNPAID");
    }

    public List<PenaltyModel> getAllPenalties() {   //  Added method
        return penaltyRepository.findAll();
    }

    public PenaltyModel payPenalty(Long penaltyId) {
        PenaltyModel penalty = penaltyRepository.findById(penaltyId)
                .orElseThrow(() -> new RuntimeException("Penalty not found"));

        if ("PAID".equalsIgnoreCase(penalty.getStatus())) {
            throw new RuntimeException("Penalty is already paid");
        }

        penalty.setStatus("PAID");
        return penaltyRepository.save(penalty);
    }
}
