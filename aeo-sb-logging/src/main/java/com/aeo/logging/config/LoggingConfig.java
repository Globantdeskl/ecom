package com.aeo.logging.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@ComponentScan(basePackages = "com.aeo.logging")
@ConfigurationProperties(prefix = "aeo-logging")
@PropertySource("classpath:application.yml")
@Data
public class LoggingConfig {
	
	private List<String> excludeRoutes;
	private List<ReplaceValue> replacements;
	private List<ConstantValue> constants;

}
