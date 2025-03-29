package com.example.Loan_r_m.v1.LoanRisk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskAssessmentResult {
    private String loanId;
    private double riskAmount;
    private int riskScore; // Example: "Low", "Medium", "High"
}
