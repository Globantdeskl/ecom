package com.app.kp.ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.kp.ai.model.PlanetEffect;

@Service
public class PlanetEffectService {

    public boolean isSaturnPeak(List<PlanetEffect> effects) {
        return effects.stream()
                .anyMatch(e -> e.getPlanet().equals("SATURN")
                        && e.getPhase().equals("PEAK"));
    }

    public boolean isVenusHealing(List<PlanetEffect> effects) {
        return effects.stream()
                .anyMatch(e -> e.getPlanet().equals("VENUS")
                        && e.getPhase().equals("HEALING"));
    }
}
