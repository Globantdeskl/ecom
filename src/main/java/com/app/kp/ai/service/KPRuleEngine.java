package com.app.kp.ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.kp.ai.model.BirthDetails;
import com.app.kp.ai.model.KPFacts;

@Service
public class KPRuleEngine {

    public KPFacts calculate(BirthDetails birth) {
        KPFacts facts = new KPFacts();
        facts.lagna = "Aries";
        facts.tenthCuspSubLord = "Saturn";
        facts.supportiveHouses = List.of(2, 6, 10, 11);
        facts.blockingHouses = List.of(12);
        facts.currentDasha = "Jupiter-Saturn";
        return facts;
    }
}