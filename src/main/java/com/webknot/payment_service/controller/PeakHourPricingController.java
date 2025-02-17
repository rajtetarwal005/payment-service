package com.webknot.payment_service.controller;

import com.webknot.payment_service.service.PeakHourPricingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/peak-hour-pricing")
public class PeakHourPricingController {
    private final PeakHourPricingService peakHourPricingService;

    public PeakHourPricingController(PeakHourPricingService peakHourPricingService) {
        this.peakHourPricingService = peakHourPricingService;
    }

    @GetMapping("/calculate")
    public double getFareWithPeakPricing(@RequestParam double baseFare, @RequestParam String travelTime) {
        LocalTime time = LocalTime.parse(travelTime);
        return peakHourPricingService.calculateFareWithPeakHourPricing(baseFare, time);
    }
}
