package com.webknot.payment_service.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "peak_hour_rules")
public class PeakHourRuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private LocalTime startTime;
    private LocalTime endTime;
    private double multiplier;

    // Manually add getter methods
    public String getStatus() {
        return status;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
