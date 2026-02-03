package com.example.aicodegen.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aicodegen.dto.CodeGenRequest;
import com.example.aicodegen.service.OpenAIService;
import com.example.aicodegen.util.FileWriterutil;
import com.example.aicodegen.util.PromptBuilder;
import com.example.aicodegen.util.ResponseParser;

@RestController
@RequestMapping("/api/codegen")
public class CodeGenController {

    private final PromptBuilder promptBuilder;
    private final OpenAIService openAIService;
    private final ResponseParser parser;
    private final FileWriterutil fileWriter;

    public CodeGenController(
            PromptBuilder promptBuilder,
            OpenAIService openAIService,
            ResponseParser parser,
            FileWriterutil fileWriter) {

        this.promptBuilder = promptBuilder;
        this.openAIService = openAIService;
        this.parser = parser;
        this.fileWriter = fileWriter;
    }

    @PostMapping("/generate/spring")
    public ResponseEntity<String> generateProject(
            @RequestBody CodeGenRequest request) {

        String prompt = promptBuilder.buildPrompt(request);
        String aiResponse = openAIService.generateCode(prompt);

        Map<String, String> code = parser.parseSections(aiResponse);
        fileWriter.write(code, request);

        return ResponseEntity.ok("✅ Spring Boot files generated successfully");
    }
}
