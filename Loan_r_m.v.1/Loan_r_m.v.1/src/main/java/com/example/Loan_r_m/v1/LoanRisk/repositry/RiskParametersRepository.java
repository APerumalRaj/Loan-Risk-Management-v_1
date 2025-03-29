package com.example.Loan_r_m.v1.LoanRisk.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import com.example.Loan_r_m.v1.LoanRisk.model.RiskParameters;

public interface RiskParametersRepository extends ReactiveCrudRepository<RiskParameters, Long> {
    
    // Fetch latest risk parameters
    Mono<RiskParameters> findTopByOrderByIdDesc();
}
