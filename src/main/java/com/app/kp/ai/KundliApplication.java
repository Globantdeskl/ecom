package com.app.kp.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.app.kp.model")
@EnableJpaRepositories(basePackages = "com.app.kp.repository")
public class KundliApplication {
    public static void main(String[] args) {
        SpringApplication.run(KundliApplication.class, args);
    }
}

