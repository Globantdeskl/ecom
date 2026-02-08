package com.aeo.checkout.sdd.config;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR 
		          || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		log.debug("::RestTemplateErrorHandler:: statusCode: {}",response.getStatusCode().toString());
		throw new RestClientException(response.getStatusCode().toString());
	}
}
