package com.example.aicodegen.service.impl;

import com.example.aicodegen.service.OpenAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final WebClient webClient;

    @Value("${openai.model}")
    private String model;

    public OpenAIServiceImpl(
            @Value("${openai.apiKey}") String apiKey,
            WebClient.Builder webClientBuilder) {

        this.webClient = webClientBuilder
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public String generateCode(String prompt) {

        Map<String, Object> body = Map.of(
                "model", model,
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", prompt
                        )
                ),
                "temperature", 0.2
        );

        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)

                // 🔥 RETRY HANDLING FOR 429
                .retryWhen(
                        Retry.backoff(3, Duration.ofSeconds(2))
                             .filter(this::isRetryable)
                )

                .block();
    }

    private boolean isRetryable(Throwable throwable) {
        return throwable instanceof WebClientResponseException.TooManyRequests;
    }
}
