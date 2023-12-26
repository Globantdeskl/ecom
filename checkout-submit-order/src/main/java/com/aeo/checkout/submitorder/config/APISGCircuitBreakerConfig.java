package com.aeo.checkout.submitorder.config;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

public interface APISGCircuitBreakerConfig {
	
	public static final String GROUP_KEY_NAME = "checkout";
	public static final HystrixCommandGroupKey GROUP_KEY = HystrixCommandGroupKey.Factory.asKey(GROUP_KEY_NAME);
	public static final String COMMAND_KEY_NAME = "apisgCall";
	public static final HystrixCommandKey COMMAND_KEY = HystrixCommandKey.Factory.asKey(COMMAND_KEY_NAME);
	public static final String STATE_LOG_KEY = "circuit_state";
	
	public static String findCircuitBreakerState() {
		HystrixCircuitBreaker cb = HystrixCircuitBreaker.Factory.getInstance(COMMAND_KEY);
		return (cb == null || !cb.isOpen()) ? "CLOSED" : "OPEN";
	}

}
