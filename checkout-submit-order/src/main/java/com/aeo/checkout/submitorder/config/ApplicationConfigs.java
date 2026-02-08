package com.aeo.checkout.submitorder.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app-configs")
@PropertySource("classpath:application.yml")
public class ApplicationConfigs {
	
	private boolean splitCallEnabled;
	private String splitCallEndpoint;
	private String submitOrderSubscription;
	private String fulfillOrderProjectId;
	private String fulfillOrderTopicName;

}
