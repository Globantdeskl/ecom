package com.aeo.checkout.fraud.config;

import org.springframework.stereotype.Component;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

import lombok.Data;

@Component
@Data
public class RedACICircuitBreakerConfig {
	
	public static final String GROUP_KEY_NAME = "checkout";
	public static final HystrixCommandGroupKey GROUP_KEY = HystrixCommandGroupKey.Factory.asKey(GROUP_KEY_NAME);
	public static final String COMMAND_KEY_NAME = "aciCall";
	public static final HystrixCommandKey COMMAND_KEY = HystrixCommandKey.Factory.asKey(COMMAND_KEY_NAME);
	
	public enum HystrixProperty {
		CIRCUITBREAKER_ENABLED("hystrix.command.%s.circuitBreaker.enabled", Boolean.class),
		FALLBACK_ENABLED("hystrix.command.%s.fallback.enabled", Boolean.class),
		TIMEOUT_ENABLED("hystrix.command.%s.execution.timeout.enabled", Boolean.class),
		REQUEST_VOLUME_THRESHOLD("hystrix.command.%s.circuitBreaker.requestVolumeThreshold", Integer.class),
		ERROR_THRESHOLD_PERCENTAGE("hystrix.command.%s.circuitBreaker.errorThresholdPercentage", Integer.class),
		SLEEP_WINDOW_MILLISECONDS("hystrix.command.%s.circuitBreaker.sleepWindowInMilliseconds", Integer.class),
		TIMEOUT_MILLISECONDS("hystrix.command.%s.execution.isolation.thread.timeoutInMilliseconds", Integer.class),
		FORCE_OPEN("hystrix.command.%s.circuitBreaker.forceOpen", Boolean.class),
		FORCE_CLOSE("hystrix.command.%s.circuitBreaker.forceClose", Boolean.class);
		
		private final String property;
		private HystrixProperty(String property, Class<?> dataType) {
			this.property = property;
		}
		
		public String propertyName() {
			return String.format(this.property, COMMAND_KEY_NAME);
		}
	}
	
	public static String findCircuitBreakerState() {
		boolean isCircuitOpen = HystrixCircuitBreaker.Factory.getInstance(COMMAND_KEY).isOpen();
		String currentState = isCircuitOpen ? "OPEN" : "CLOSED";
		return currentState;
	}
	
	public static void updateProperty(HystrixProperty property, Object update) {
		ConfigurationManager.getConfigInstance().setProperty(property.propertyName(), update);
	}
	
	public void configure(boolean enabled, boolean timeoutEnabled,
			int requestVolumeThreshold, int errorThresholdPercentage, 
			int sleepWindowInMilliseconds, int timeoutInMilliseconds) {
		HystrixCommand.Setter.withGroupKey(GROUP_KEY).andCommandKey(COMMAND_KEY)
		.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
			.withCircuitBreakerEnabled(enabled)
			.withCircuitBreakerRequestVolumeThreshold(requestVolumeThreshold)
			.withCircuitBreakerErrorThresholdPercentage(errorThresholdPercentage)
			.withCircuitBreakerSleepWindowInMilliseconds(sleepWindowInMilliseconds)
			.withExecutionTimeoutEnabled(timeoutEnabled)
			.withExecutionTimeoutInMilliseconds(timeoutInMilliseconds)
			.withFallbackEnabled(true));
	}
}
