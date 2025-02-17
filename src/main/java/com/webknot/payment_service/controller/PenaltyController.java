package com.webknot.payment_service.controller;

import com.webknot.payment_service.model.PenaltyModel;
import com.webknot.payment_service.service.PenaltyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyController {
    private final PenaltyService penaltyService;

    public PenaltyController(PenaltyService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @PostMapping("/create")
    public PenaltyModel imposePenalty(@RequestBody PenaltyModel penalty) {
        return penaltyService.createPenalty(penalty);
    }

    @GetMapping("/unpaid/{userId}")
    public List<PenaltyModel> getUnpaidPenalties(@PathVariable Long userId) {
        return penaltyService.getUnpaidPenalties(userId);
    }

    @GetMapping  // Added this route
    public List<PenaltyModel> getAllPenalties() {
        return penaltyService.getAllPenalties();
    }

    @PutMapping("/pay/{penaltyId}")
    public PenaltyModel payPenalty(@PathVariable Long penaltyId) {
        return penaltyService.payPenalty(penaltyId);
    }
}
