package com.example.Loan_r_m.v1.LoanRisk.service;

import org.springframework.stereotype.Service;

@Service
public class RiskScoringEngine {

    public int calculateRiskScore(double loanAmount, String creditHistory, double income) {
        int score = 100;

        // Deduct points based on risk factors
        if (loanAmount > 100000) score -= 20;
        if ("bad".equalsIgnoreCase(creditHistory)) score -= 50;
        if (income < 5000) score -= 30;

        return Math.max(score, 0); // Ensure score is not negative
    }
}