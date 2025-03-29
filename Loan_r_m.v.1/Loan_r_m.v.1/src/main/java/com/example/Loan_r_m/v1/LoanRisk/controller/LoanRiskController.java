package com.example.Loan_r_m.v1.LoanRisk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import com.example.Loan_r_m.v1.LoanRisk.service.LoanRiskService;
import com.example.Loan_r_m.v1.LoanRisk.model.LoanApplication;
import com.example.Loan_r_m.v1.LoanRisk.model.RiskAssessmentResult;

@RestController
@RequestMapping("/loan-risk")
public class LoanRiskController {

    private final LoanRiskService loanRiskService;

    public LoanRiskController(LoanRiskService loanRiskService) {
        this.loanRiskService = loanRiskService;
    }

    @PostMapping("/assess")
    public Mono<ResponseEntity<RiskAssessmentResult>> assessLoanRisk(@RequestBody LoanApplication application) {
        return loanRiskService.evaluateRisk(application)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
}
