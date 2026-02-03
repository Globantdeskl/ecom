package com.example.aicodegen.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.aicodegen.dto.CodeRule;

@Component
public class RuleRepository {

    public List<CodeRule> fetchRules() {
        return List.of(
            new CodeRule("R1", "Use constructor injection only"),
            new CodeRule("R2", "Controllers must return ResponseEntity"),
            new CodeRule("R3", "Service layer must be interface based"),
            new CodeRule("R4", "Use Lombok @Data for DTOs"),
            new CodeRule("R5", "Add validation annotations")
        );
    }
}
