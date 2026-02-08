package com.aeo.logging;

import static net.logstash.logback.argument.StructuredArguments.kv;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import com.aeo.logging.config.LoggingConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ResponseTimeLogger {
	
	private static final String START_TIME = "start_time";
	
	private final LoggingConfig config;
	
	public ResponseTimeLogger(LoggingConfig config) {
		this.config = config;
	}
	
	@Bean
    public AbstractRequestLoggingFilter logFilter() {
		
		AbstractRequestLoggingFilter filter = new AbstractRequestLoggingFilter() {
        	
            @Override
            protected void beforeRequest(HttpServletRequest request, String message) {
                request.setAttribute(START_TIME, Instant.now().toEpochMilli());
            }

            @Override
            protected void afterRequest(HttpServletRequest request, String message) {
            	long diff = Instant.now().toEpochMilli() - (Long) request.getAttribute(START_TIME);
                log.info(message + " {}", kv(RequestProperty.RESPONSE_TIME.key(), Long.toString(diff)));
            }

            @Override
            protected boolean shouldNotFilter(HttpServletRequest request) {
            	return config.getExcludeRoutes() == null ? false : config.getExcludeRoutes().stream()
            			.anyMatch(route -> request.getRequestURI().contains(route));
            }
        };

        filter.setIncludeQueryString(true);
        filter.setIncludePayload(false);
        filter.setIncludeHeaders(false);

        return filter;
    }

}
