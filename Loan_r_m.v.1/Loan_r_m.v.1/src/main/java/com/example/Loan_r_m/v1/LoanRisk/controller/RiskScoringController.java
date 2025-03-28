package com.example.Loan_r_m.v1.LoanRisk.controller;

import com.example.loanrisk.service.RiskScoringEngine;
import com.example.loanrisk.model.RiskEvaluationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk")
public class RiskScoringController {

    private final RiskScoringEngine riskScoringEngine;

    public RiskScoringController(RiskScoringEngine riskScoringEngine) {
        this.riskScoringEngine = riskScoringEngine;
    }

    @PostMapping("/evaluate")
    public String evaluateRisk(@RequestBody RiskEvaluationRequest request) {
        int riskScore = riskScoringEngine.calculateRiskScore(
                request.getLoanAmount(),
                request.getCreditHistory(),
                request.getIncome()
        );

        return "Loan ID: " + request.getLoanId() + " | Risk Score: " + riskScore;
    }
}