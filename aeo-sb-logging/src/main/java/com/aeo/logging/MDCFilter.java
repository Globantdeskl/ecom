package com.aeo.logging;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aeo.logging.config.LoggingConfig;

@Profile("!chaos-monkey")
@Component
public class MDCFilter extends OncePerRequestFilter {
	
	private static final String REFERER_HEADER = "referer";
	
	private final Environment env;
	private final LoggingConfig config;
	
	public MDCFilter(Environment env, LoggingConfig config) {
		super();
		this.env = env;
		this.config = config;
		addAppData(env, config);
	}
	
	private static void addAppData(Environment env, LoggingConfig config) {
		Arrays.asList(EnvProperty.values()).stream().forEach(prop -> 
			MDC.put(prop.key(), env.getProperty(prop.propName())));
		if(config.getConstants() != null) {
			config.getConstants().stream().forEach(con -> 
				MDC.put(con.getKey(), con.getValue()));
		}
		if(config.getReplacements() != null) {
			config.getReplacements().stream().forEach(rep -> 
			    MDC.put(rep.getKey().key(), rep.getValue()));
		}
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		addAppData(env, config);
		
		MDC.put(RequestProperty.APP_HOST.key(), request.getLocalName());
		MDC.put(RequestProperty.APP_IP.key(), request.getLocalAddr());
		MDC.put(RequestProperty.APP_PORT.key(), Integer.toString(request.getLocalPort()));
		
		MDC.put(RequestProperty.REMOTE_HOST.key(), request.getRemoteHost());
		MDC.put(RequestProperty.REMOTE_IP.key(), request.getRemoteAddr());
		MDC.put(RequestProperty.REMOTE_PORT.key(), Integer.toString(request.getRemotePort()));
		MDC.put(RequestProperty.HTTP_METHOD.key(), request.getMethod());
		MDC.put(RequestProperty.HTTP_ENDPOINT.key(), request.getRequestURI());
		MDC.put(RequestProperty.HTTP_QUERY.key(), request.getQueryString());
		MDC.put(RequestProperty.HTTP_REFERER.key(), request.getHeader(REFERER_HEADER));
		MDC.put(RequestProperty.STATUS_CODE.key(), Integer.toString(response.getStatus()));
		
		try {
			filterChain.doFilter(request, response);
		} finally {
			Arrays.asList(RequestProperty.values()).stream()
				.filter(key -> key.remove())
				.forEach(key -> MDC.remove(key.key()));
		}
	}

}
