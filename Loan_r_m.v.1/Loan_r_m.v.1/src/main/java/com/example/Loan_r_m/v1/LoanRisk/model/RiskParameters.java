package com.example.Loan_r_m.v1.LoanRisk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("risk_parameters")  
public class RiskParameters {

    @Id
    private Long id;
    private double loanAmountRatio;
    private int creditScoreThreshold;
    private int highDebtPenalty;
    private int lowCreditPenalty;
}
