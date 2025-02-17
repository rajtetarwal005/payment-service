package com.webknot.payment_service.repository;

import com.webknot.payment_service.model.PenaltyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenaltyRepository extends JpaRepository<PenaltyModel, Long> {
    List<PenaltyModel> findByUserIdAndStatus(Long userId, String status);
}
