package com.example.Loan_r_m.v1.Model;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public Flux<CustomerModel> getAllCustomers() {
        return service.getAllCustomers();
    }

    // @GetMapping
    // public String getAllCustomers() {
    //     return "Working Fine";
    // }
    
    @GetMapping("/{id}")
    public Mono<CustomerModel>  getCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    @PostMapping
    public Mono<String> addCustomer(@RequestBody CustomerModel customer) {
        return service.addCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public Mono<String> deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }
    
}
