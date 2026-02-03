package com.example.aicodegen.util;

import com.example.aicodegen.dto.CodeGenRequest;
import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    public String buildPrompt(CodeGenRequest req) {

        return """
        You are a senior Spring Boot architect.

        Generate clean, production-ready Java code.
        Use:
        - Java 17
        - Spring Boot 3
        - JPA
        - Lombok
        - REST best practices

        Base Package:
        %s

        Database Table:
        %s

        Requirements:
        - Entity with JPA annotations
        - DTO
        - Repository extends JpaRepository
        - Service interface + implementation
        - REST Controller
        - Validation annotations

        Output Format (STRICT):
        ### Entity
        ### DTO
        ### Repository
        ### Service
        ### ServiceImpl
        ### Controller
        """.formatted(
                req.getBasePackage(),
                req.getTableSchema()
        );
    }
}
