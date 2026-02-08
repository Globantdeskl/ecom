package com.aeo.framework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Value("${checkout-framework.env}")
    Environment environment;

    @Bean
    public Environment getEnvironment() {
        return environment;
    }
}
