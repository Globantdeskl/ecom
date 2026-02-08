package com.aeo.framework.encoder;

import feign.Request;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

@Slf4j
public class CustomEncoder extends feign.Logger {
    private final org.slf4j.Logger logger;

    public CustomEncoder(Class<?> clazz) {
        this(LoggerFactory.getLogger(clazz));
    }

    public CustomEncoder(String name) {
        this(LoggerFactory.getLogger(name));
    }

    CustomEncoder(org.slf4j.Logger logger) {
        this.logger = logger;
    }


    @Override
    protected void log(String configKey, String format, Object... args) {
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        log.info("request: " + request.url() + "\n" +
                "Body: " + new String(request.body()), StandardCharsets.UTF_8);
    }
}
