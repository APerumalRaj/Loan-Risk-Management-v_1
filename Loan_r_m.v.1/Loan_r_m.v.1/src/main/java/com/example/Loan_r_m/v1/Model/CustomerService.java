package com.example.Loan_r_m.v1.Model;

import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {
 private final CustomerRepository repository;

    public Flux<CustomerModel> getAllCustomers(){
            return repository.findAll();
    }

    public Mono<CustomerModel> getCustomerById(int id){
        return repository.findById(id);
    }

    public Mono<String> addCustomer(CustomerModel customer) {
         repository.save(customer);
         return Mono.just("Added Succefully");
    }

    public Mono<String> deleteCustomer(int id) {
         repository.deleteById(id);
         return Mono.just("Deleted");
    }
    
}
