package com.aeo.checkout.tax;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = CheckoutTaxCalculatorApplication.class)
class CheckoutTaxCalculatorApplicationTests {

	@LocalServerPort
	int randomServerPort;
	 
	@Test
	public void healthPage() throws RestClientException, URISyntaxException {
		System.out.println(randomServerPort);
		ResponseEntity<String> response = new RestTemplate().getForEntity(getURI("/actuator/health"), String.class);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains("{\"status\":\"UP\"}"));
	}
	
	private URI getURI(String endpoint) throws URISyntaxException {
		return new URI(new StringBuilder("http://localhost").append(":").append(randomServerPort).append(endpoint).toString());
	}
}
