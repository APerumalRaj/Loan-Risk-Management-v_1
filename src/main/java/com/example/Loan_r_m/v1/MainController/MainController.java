package com.example.Loan_r_m.v1.MainController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;


@RestController
public class MainController {
    @GetMapping("/")
    public Mono<String> home() {
        return Mono.just("Welcome to Loan Risk Management API");
    }
}
