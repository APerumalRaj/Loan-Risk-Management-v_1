package com.example.Loan_r_m.v1.LoanRisk.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.example.Loan_r_m.v1.LoanRisk.repository.RiskParametersRepository;
import com.example.Loan_r_m.v1.LoanRisk.model.RiskParameters;
import com.example.Loan_r_m.v1.LoanRisk.model.RiskEvaluationRequest;

@Service
public class RiskScoringEngine {

    private final RiskParametersRepository repository;

    public RiskScoringEngine(RiskParametersRepository repository) {
        this.repository = repository;
    }

    public Mono<Integer> calculateRiskScore(RiskEvaluationRequest request) {
        return repository.findTopByOrderByIdDesc()
                .defaultIfEmpty(new RiskParameters()) // Use default values if no data found
                .map(params -> {
                    int score = 100;

                    // Deduct points based on database values
                    if (request.getLoanAmount() > params.getLoanAmountRatio()) {
                        score -= params.getHighDebtPenalty(); // Use high debt penalty
                    }
                    if ("bad".equalsIgnoreCase(request.getCreditHistory())) {
                        score -= params.getLowCreditPenalty(); // Use low credit penalty
                    }
                    
                    return Math.max(score, 0); // Ensure score is not negative
                });
    }
}
