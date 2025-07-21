package com.securityai.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.securityai")
public class AiSecuritySystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiSecuritySystemApplication.class, args);
    }
}
