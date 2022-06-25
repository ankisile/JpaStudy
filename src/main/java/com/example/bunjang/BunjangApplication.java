package com.example.bunjang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BunjangApplication {

    public static void main(String[] args) {
        SpringApplication.run(BunjangApplication.class, args);
    }

}
