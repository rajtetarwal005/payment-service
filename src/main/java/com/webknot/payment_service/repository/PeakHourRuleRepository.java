package com.webknot.payment_service.repository;

import com.webknot.payment_service.model.PeakHourRuleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeakHourRuleRepository extends JpaRepository<PeakHourRuleModel, Long> {
}

