package com.example.Loan_r_m.v1.LoanRisk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplication {
    private String creditId;
    private double loanAmount;
    private int creditScore;
    private double annualIncome;
}
