package com.example.Loan_r_m.v1.Config;

import jakarta.annotation.PostConstruct;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DatabaseInitializer {

    private final DatabaseClient databaseClient;

    public DatabaseInitializer(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @PostConstruct
    public void initializeDatabase() {
        databaseClient.sql("""
            CREATE TABLE IF NOT EXISTS risk_parameters (
                id SERIAL PRIMARY KEY,
                loan_amount_ratio DOUBLE PRECISION NOT NULL,
                credit_score_threshold INT NOT NULL,
                high_debt_penalty INT NOT NULL,
                low_credit_penalty INT NOT NULL
            )
        """).then().subscribe();

        databaseClient.sql("""
            CREATE TABLE IF NOT EXISTS customer_details (
                id SERIAL PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                amount INT NOT NULL,
                loan INT NOT NULL,
                interest_rate DOUBLE PRECISION NOT NULL
            )
        """).then().subscribe();

        databaseClient.sql("""
            INSERT INTO risk_parameters (loan_amount_ratio, credit_score_threshold, high_debt_penalty, low_credit_penalty)
            SELECT 5.0, 600, 30, 40
            WHERE NOT EXISTS (SELECT 1 FROM risk_parameters)
        """).then().subscribe();
    }
}
