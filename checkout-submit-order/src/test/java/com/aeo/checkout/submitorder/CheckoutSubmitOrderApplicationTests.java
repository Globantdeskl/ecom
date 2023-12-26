package com.aeo.checkout.submitorder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = CheckoutSubmitOrderApplication.class)
class CheckoutSubmitOrderApplicationTests {

	@LocalServerPort
	int randomServerPort;
	 
	@Test
	void healthPage() throws RestClientException, URISyntaxException {
		URI uri = getURI("/actuator/health/ping");
		ResponseEntity<String> response = new RestTemplate().getForEntity(uri, String.class);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains("UP"));
	}
	
	private URI getURI(String endpoint) throws URISyntaxException {
		return new URI(new StringBuilder("http://localhost")
				.append(":")
				.append(randomServerPort)
				.append(endpoint)
				.toString());
	}

}
