package com.example.Loan_r_m.v1.LoanRisk.model;

import lombok.Data;

@Data
public class RiskEvaluationRequest {
    
    private String loanId;
    private double loanAmount;
    private String creditHistory;
    private double income;
}
