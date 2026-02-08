package com.aeo.checkout.submitorder.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Primary
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate rt = new RestTemplateBuilder()
				.errorHandler(new RestTemplateErrorHandler())
				.build(RestTemplate.class);
		rt.setRequestFactory(requestFactory());
		return rt;
	}
	
	private ClientHttpRequestFactory requestFactory() {
		SimpleClientHttpRequestFactory rf = new SimpleClientHttpRequestFactory();
		rf.setConnectTimeout(60000);
		rf.setReadTimeout(60000);
		return rf;
	}

}
