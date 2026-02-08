package com.aeo.checkout.sdd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "sdd.service")
@Data
public class SDDApplicationProperties {
	private String patchurl;
	private String auth;
}
