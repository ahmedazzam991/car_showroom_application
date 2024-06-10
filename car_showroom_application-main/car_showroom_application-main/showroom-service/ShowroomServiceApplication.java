package com.example.showroomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShowroomServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShowroomServiceApplication.class, args);
    }
}

