package com.app.kp.ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.kp.ai.model.MarriageStatus;
import com.app.kp.ai.model.Person;
import com.app.kp.ai.model.PlanetEffect;

@Service
public class MarriageAnalysisService {

    private final PlanetEffectService planetEffectService;

    public MarriageAnalysisService(PlanetEffectService planetEffectService) {
        this.planetEffectService = planetEffectService;
    }

    public MarriageStatus analyzeMarriage(
            Person husband,
            List<PlanetEffect> effects) {

        MarriageStatus status = new MarriageStatus();
        status.setHusband(husband);

        boolean saturnPeak = planetEffectService.isSaturnPeak(effects);
        boolean venusHealing = planetEffectService.isVenusHealing(effects);

        status.setBroken(false); // Saturn never breaks, only tests
        status.setStressed(saturnPeak);
        status.setRecoverable(venusHealing);

        return status;
    }
}

