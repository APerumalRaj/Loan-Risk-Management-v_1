package com.example.Loan_r_m.v1.LoanRisk.model;

public class RiskEvaluationRequest {
    private String loanId;
    private double loanAmount;
    private String creditHistory;
    private double income;

    // Getters and setters
    public String getLoanId() { return loanId; }
    public void setLoanId(String loanId) { this.loanId = loanId; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

    public String getCreditHistory() { return creditHistory; }
    public void setCreditHistory(String creditHistory) { this.creditHistory = creditHistory; }

    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }
}
