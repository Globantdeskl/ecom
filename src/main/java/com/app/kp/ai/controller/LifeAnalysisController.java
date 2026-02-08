package com.app.kp.ai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kp.ai.model.MarriageStatus;
import com.app.kp.ai.model.Person;
import com.app.kp.ai.model.PlanetEffect;
import com.app.kp.ai.service.MarriageAnalysisService;

@RestController
@RequestMapping("/life")
public class LifeAnalysisController {

    private final MarriageAnalysisService marriageService;

    public LifeAnalysisController(MarriageAnalysisService marriageService) {
        this.marriageService = marriageService;
    }

    @PostMapping("/marriage/analyze")
    public MarriageStatus analyzeMarriage(
            @RequestBody Person person,
            @RequestBody List<PlanetEffect> effects) {

        return marriageService.analyzeMarriage(person, effects);
    }
}
