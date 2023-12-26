package com.aeo.framework.clients;

import com.aeo.framework.model.response.TaxResponseBody;
import com.google.gson.JsonObject;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface TaxCalculatorClient {

    @RequestLine("GET /v1/order/fulfillment/{isbn}")
    JsonObject findByIsbn(@Param("isbn") String isbn);

    @RequestLine("POST /calculate")
    @Headers("Content-Type: application/json")
    @Body("{body}")
    TaxResponseBody calculate(@Param("body") String body);
}
