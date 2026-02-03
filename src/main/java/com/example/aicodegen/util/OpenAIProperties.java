package com.example.aicodegen.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openai")
public class OpenAIProperties {
    private String apiKey;
    private String model;
}

