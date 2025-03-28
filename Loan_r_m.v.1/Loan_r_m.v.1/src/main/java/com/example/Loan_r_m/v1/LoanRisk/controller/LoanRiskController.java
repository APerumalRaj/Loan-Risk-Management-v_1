package com.example.Loan_r_m.v1.LoanRisk.controller;

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
                .map(result -> ResponseEntity.ok(result))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
}
