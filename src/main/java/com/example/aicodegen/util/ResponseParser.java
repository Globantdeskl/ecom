package com.example.aicodegen.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseParser {

    public Map<String, String> parseSections(String response) {

        Map<String, String> result = new HashMap<>();

        result.put("entity", extract(response, "### Entity", "### DTO"));
        result.put("dto", extract(response, "### DTO", "### Repository"));
        result.put("repository", extract(response, "### Repository", "### Service"));
        result.put("service", extract(response, "### Service", "### ServiceImpl"));
        result.put("serviceImpl", extract(response, "### ServiceImpl", "### Controller"));
        result.put("controller", extract(response, "### Controller", null));

        return result;
    }

    private String extract(String text, String start, String end) {
        int startIndex = text.indexOf(start);
        if (startIndex == -1) return "";

        startIndex += start.length();
        int endIndex = (end != null && text.indexOf(end) != -1)
                ? text.indexOf(end)
                : text.length();

        return text.substring(startIndex, endIndex).trim();
    }
}

