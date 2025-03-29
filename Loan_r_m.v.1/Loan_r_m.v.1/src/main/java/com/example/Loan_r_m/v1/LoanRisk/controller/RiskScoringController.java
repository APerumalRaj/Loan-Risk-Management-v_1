package com.example.Loan_r_m.v1.LoanRisk.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.example.Loan_r_m.v1.LoanRisk.service.RiskScoringEngine;
import com.example.Loan_r_m.v1.LoanRisk.model.RiskEvaluationRequest;

@RestController
@RequestMapping("/risk")
public class RiskScoringController {

    private final RiskScoringEngine riskScoringEngine;

    public RiskScoringController(RiskScoringEngine riskScoringEngine) {
        this.riskScoringEngine = riskScoringEngine;
    }

    @PostMapping("/evaluate")
    public Mono<Integer> evaluateRisk(@RequestBody RiskEvaluationRequest request) {
        return riskScoringEngine.calculateRiskScore(request);
    }
}
