package com.aeo.checkout.submitorder.service;

import com.aeo.checkout.submitorder.config.ApplicationConfigs;
import com.aeo.checkout.submitorder.model.atg.ATGResponse;
import com.aeo.checkout.submitorder.model.atg.ATGResponseError;
import com.aeo.postcheckout.model.order.ATGOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

@SpringBootTest
public class ATGSplitOrderServiceTest {

    private ATGSplitOrderService atgSplitOrderService;

    @Mock
    private ApplicationConfigs configs;

    @Mock
    private RestTemplate restTemplate;

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() throws JsonProcessingException {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        atgSplitOrderService = new ATGSplitOrderService(restTemplate, "basic");
    }

    @Test
    void testSplitCall() {
        String orderId = "mockOrderId01";
        Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(ATGResponse.class)))
                .thenReturn(ResponseEntity.ok().body(SplitCallWrapperService.createMockATGResponse(orderId, objectMapper)));

        ResponseEntity<ATGResponse> response = atgSplitOrderService.splitCall("endpoint", orderId);

        assertTrue(response.getBody().hasOrder());
        assertEquals(orderId, response.getBody().getMessage().getHeader().getMessageId());

        Mockito.verify(restTemplate, times(1)).exchange(
                ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(ATGResponse.class));
    }

    @Test
    void testSplitRetry() {
        assertThrows(RestClientException.class, () ->
                atgSplitOrderService.splitCall(new RestClientException("Error Split"), "endpoint", "mockId"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testSplitCallNoResponse() {
        String orderId = "mockOrderId01";

        ATGResponseError error = new ATGResponseError();
        error.setKey("mock_error");
        ATGResponse atgErrorResp = SplitCallWrapperService.createMockATGResponse(orderId, objectMapper);
        atgErrorResp.setError(error);

        ATGResponse atgNoOrderResp = SplitCallWrapperService.createMockATGResponse(orderId, objectMapper);
        atgNoOrderResp.setMessage(new ATGOrder());

        Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.any(), ArgumentMatchers.eq(ATGResponse.class)))
                .thenReturn(ResponseEntity.ok(null),
                        ResponseEntity.ok(atgErrorResp),
                        ResponseEntity.ok(atgNoOrderResp));

        ResponseEntity<ATGResponse> nullResp = atgSplitOrderService.splitCall("endpoint", orderId);
        assertNull(nullResp.getBody());

        ResponseEntity<ATGResponse> errorResp = atgSplitOrderService.splitCall("endpoint", orderId);
        assertNotNull(errorResp.getBody().getError());

        ResponseEntity<ATGResponse> noOrderResp = atgSplitOrderService.splitCall("endpoint", orderId);
        assertTrue(noOrderResp.getBody().getMessage().getCollectionSize() == 0);

        Mockito.verify(restTemplate, times(3)).exchange(
                ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(ATGResponse.class));
    }

    @Test
    void testSplitCallFailed() {
        String orderId = "mockOrderId01";
        Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(ATGResponse.class)))
                .thenThrow(RestClientException.class);

        assertThrows(RestClientException.class, () -> atgSplitOrderService.splitCall("endpoint", orderId));

        Mockito.verify(restTemplate, times(1)).exchange(
                ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(ATGResponse.class));
    }

}
