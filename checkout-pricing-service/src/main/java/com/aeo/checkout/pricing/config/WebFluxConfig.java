package com.aeo.checkout.pricing.config;

import static net.logstash.logback.argument.StructuredArguments.v;

import java.net.ConnectException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.http.client.HttpClient;

@Slf4j
@EnableWebFlux
@Configuration
public class WebFluxConfig {
	
	private static final String ENDPOINT_KEY = "endpoint";
	private static final String RESOURCE_ID_KEY = "resource_id";
	
	@Primary
	@Bean
	public WebClient webClient() {
		
		HttpClient httpClient = HttpClient.create()
				.keepAlive(true)
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
				.doOnConnected(connection -> connection
						.addHandlerLast(new ReadTimeoutHandler(5, TimeUnit.SECONDS))
						.addHandlerLast(new WriteTimeoutHandler(5, TimeUnit.SECONDS))
						);
		
		return WebClient.builder()
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.build();
	}
	
	public static Function<Throwable, Throwable> mapExceptions(String endpoint, String id) {
		return e -> {
			Throwable t = e;
			if(e instanceof ConnectException 
					|| e.getCause() instanceof ConnectException) {
				log.error("Failed Connecting to {}: {}", v(ENDPOINT_KEY, endpoint), v(RESOURCE_ID_KEY, id), e);
				t = new RuntimeException(e);
			}
			log.error("Failed Calling {}: {}", v(ENDPOINT_KEY, endpoint), v(RESOURCE_ID_KEY, id), e);
			return t;
		};
	}
	
}
