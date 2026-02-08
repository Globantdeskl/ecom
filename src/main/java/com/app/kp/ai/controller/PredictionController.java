package com.app.kp.ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kp.ai.model.PredictionRequest;
import com.app.kp.ai.model.PredictionResponse;
import com.app.kp.ai.service.PredictionService;

@RestController
@RequestMapping("/api/kp")
public class PredictionController {

    private final PredictionService service;

    public PredictionController(PredictionService service) {
        this.service = service;
    }

    @PostMapping("/predict")
    public PredictionResponse predict(@RequestBody PredictionRequest request) {
        return service.predict(request);
    }
}