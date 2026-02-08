package com.app.kp.ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.kp.ai.model.KPFacts;
import com.app.kp.ai.model.PredictionRequest;
import com.app.kp.ai.model.PredictionResponse;

@Service
public class PredictionService {

    private final KPRuleEngine ruleEngine;
    private final KPRagService ragService;
    private final LLMService llmService;

    public PredictionService(KPRuleEngine ruleEngine, KPRagService ragService, LLMService llmService) {
        this.ruleEngine = ruleEngine;
        this.ragService = ragService;
        this.llmService = llmService;
    }

    public PredictionResponse predict(PredictionRequest request) {
        KPFacts facts = ruleEngine.calculate(request.birthDetails);
        List<String> rules = ragService.retrieveRules(facts, request.question);
        String prompt = facts + "\n" + rules + "\n" + request.question;
        return new PredictionResponse(llmService.generatePrediction(prompt));
    }
}