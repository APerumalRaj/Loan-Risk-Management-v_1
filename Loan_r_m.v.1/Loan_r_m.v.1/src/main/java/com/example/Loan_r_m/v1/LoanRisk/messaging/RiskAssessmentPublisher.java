package com.example.Loan_r_m.v1.LoanRisk.messaging;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.loanrisk.model.LoanApplication;

@Component
public class RiskAssessmentPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    public RiskAssessmentPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendRiskAssessmentRequest(LoanApplication application) {
        rabbitTemplate.convertAndSend(exchange, routingKey, application);
    }
}
