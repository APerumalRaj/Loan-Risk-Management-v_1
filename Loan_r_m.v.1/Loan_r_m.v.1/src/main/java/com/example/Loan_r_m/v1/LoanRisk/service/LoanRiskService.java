package com.example.Loan_r_m.v1.LoanRisk.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.Loan_r_m.v1.LoanRisk.model.LoanApplication;
import com.example.Loan_r_m.v1.LoanRisk.model.RiskAssessmentResult;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class LoanRiskService {

    @Cacheable(value = "loanRiskCache", key = "#application.clientId")
    public Mono<RiskAssessmentResult> evaluateRisk(LoanApplication application) {
        return Mono.fromCallable(() -> {
            // Compute risk score based on configurable factors
            int score = computeRiskScore(application);
            return new RiskAssessmentResult(application.getCreditId(), application.getLoanAmount(), score);
        }).subscribeOn(Schedulers.boundedElastic());
    }

    private int computeRiskScore(LoanApplication application) {
        return 0;  // TODO: Implement risk scoring logic
    }
}
