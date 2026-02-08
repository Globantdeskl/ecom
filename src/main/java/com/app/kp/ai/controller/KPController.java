package com.app.kp.ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kp.ai.model.BirthDetails;
import com.app.kp.ai.model.KPResponse;
import com.app.kp.ai.service.KPCalculationService;

@RestController
@RequestMapping("/api/kp")
public class KPController {

    private final KPCalculationService service;

    public KPController(KPCalculationService service) {
        this.service = service;
    }

    @PostMapping("/kundli")
    public KPResponse generateKundli(@RequestBody BirthDetails birth) {
        return new KPResponse(
            service.calculatePlanets(birth),
            service.calculateCusps(birth)
        );
    }
}




