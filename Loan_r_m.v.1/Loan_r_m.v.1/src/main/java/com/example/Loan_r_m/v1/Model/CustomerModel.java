package com.example.Loan_r_m.v1.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table(name = "Customer_Details") // Use @Table instead of @Entity
public class CustomerModel {

    @Id // Use Spring Data annotation, not JPA
    private Integer id;

    private String name;
    private int amount;
    private int loan;
    private Double interestRate;

    public CustomerModel(Integer id, String name, int amount, int loan, Double interestRate) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.loan = loan;
        this.interestRate = interestRate;
    }

    public CustomerModel() {}
}
