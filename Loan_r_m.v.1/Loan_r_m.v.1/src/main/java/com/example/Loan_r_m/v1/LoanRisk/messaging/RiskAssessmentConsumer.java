package com.example.Loan_r_m.v1.LoanRisk.messaging;

import com.example.Loan_r_m.v1.LoanRisk.model.LoanApplication;
import com.example.Loan_r_m.v1.LoanRisk.service.LoanRiskService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RiskAssessmentConsumer {

    private final LoanRiskService loanRiskService;

    public RiskAssessmentConsumer(LoanRiskService loanRiskService) {
        this.loanRiskService = loanRiskService;
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void processRiskAssessment(LoanApplication application) {
        loanRiskService.evaluateRisk(application)
                .subscribe(result -> System.out.println("Risk Assessment Completed: " + result));
    }
}
