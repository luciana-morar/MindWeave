package com.mindweave.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mindweave")
public class MindWeaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MindWeaveApplication.class, args);
    }
}
