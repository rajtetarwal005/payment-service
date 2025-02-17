package com.webknot.payment_service.service;

import com.webknot.payment_service.model.PeakHourRuleModel;
import com.webknot.payment_service.repository.PeakHourRuleRepository;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.List;

@Service
public class PeakHourPricingService {
    private final PeakHourRuleRepository peakHourRuleRepository;

    public PeakHourPricingService(PeakHourRuleRepository peakHourRuleRepository) {
        this.peakHourRuleRepository = peakHourRuleRepository;
    }

    public List<PeakHourRuleModel> getActiveRules() {
        return peakHourRuleRepository.findAll()
                .stream()
                .filter(rule -> rule.getStatus().equalsIgnoreCase("ACTIVE"))
                .toList();
    }

    public double calculateFareWithPeakHourPricing(double baseFare, LocalTime travelTime) {
        List<PeakHourRuleModel> activeRules = getActiveRules();

        for (PeakHourRuleModel rule : activeRules) {
            if (travelTime.isAfter(rule.getStartTime()) && travelTime.isBefore(rule.getEndTime())) {
                return baseFare * rule.getMultiplier(); // Applying peak hour pricing multiplier
            }
        }

        return baseFare; // No peak pricing applicable
    }
}

