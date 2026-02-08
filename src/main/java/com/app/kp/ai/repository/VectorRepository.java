package com.app.kp.ai.repository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class VectorRepository {

    public List<String> searchRelevantRules(String query) {
        return List.of(
            "10th house with 6th and 11th indicates service job.",
            "Favorable dasha lord confirms timing of event.",
            "12th house involvement indicates foreign connection."
        );
    }
}