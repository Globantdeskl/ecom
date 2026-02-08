package com.app.kp.ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.kp.ai.model.KPFacts;
import com.app.kp.ai.repository.VectorRepository;

@Service
public class KPRagService {

    private final VectorRepository vectorRepository;

    public KPRagService(VectorRepository vectorRepository) {
        this.vectorRepository = vectorRepository;
    }

    public List<String> retrieveRules(KPFacts facts, String question) {
        return vectorRepository.searchRelevantRules(question + " " + facts.tenthCuspSubLord);
    }
}