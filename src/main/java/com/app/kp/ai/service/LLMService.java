package com.app.kp.ai.service;

import org.springframework.stereotype.Service;

@Service
public class LLMService {

    public String generatePrediction(String prompt) {
        return "Prediction generated using KP rules and AI reasoning.";
    }
}