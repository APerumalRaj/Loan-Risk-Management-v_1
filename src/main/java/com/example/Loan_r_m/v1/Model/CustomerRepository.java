package com.example.Loan_r_m.v1.Model;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends ReactiveCrudRepository<CustomerModel,Integer>{

    
} 